package com.sv.app.controller;

import static java.lang.String.format;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sv.app.bean.ApplicationStatusBean;
import com.sv.app.bean.AttachedDocumentBean;
import com.sv.app.bean.EmployeeBean;
import com.sv.app.bean.VendorBean;
import com.sv.app.service.ApplicationStatusService;
import com.sv.app.service.AttachedDocumentService;
import com.sv.app.service.EmployeeService;
import com.sv.app.service.VendorService;
import com.sv.app.util.DatabaseSequenceCreator;
import com.sv.app.util.DatabaseSequenceProvider;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersisterController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	VendorService vendorService;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	AttachedDocumentService attachedDocumenService;

	@Autowired
	ApplicationStatusService applicationStatusService;
	
	@Autowired
	DatabaseSequenceCreator databaseSequenceCreator;
	
	@Autowired
	DatabaseSequenceProvider databaseSequenceProvider;
	
	

	@Value("${file.upload-dir}")
	private String IMAGES_DIR;

	private static final String APP_NUMBER_SEQ_PREFIX = "SEQ_APPLICATION_NUMBER_%s";
	private static final String APP_NUMBER_FORMAT = "SV/%s/%s/%s";

	@PostMapping(value = "/save", headers = "Accept=application/json")
	@ResponseBody
	public EmployeeBean createEmployee(@Valid @RequestBody final EmployeeBean employeeBean) {
		EmployeeBean empBean = employeeBean;
		EmployeeBean response = employeeService.save(empBean);
		return response;
	}

	
//	
	@PostMapping(value = "/reg-vendor", headers = "Accept=application/json")
	@ResponseBody
	public VendorBean registerVendor(@Valid @RequestBody final VendorBean vendorBean,
			@RequestHeader("auth_token") String auth_token) {
		VendorBean VenBean = vendorBean;
		EmployeeBean employeeBean = employeeService.findbyAuthToken(auth_token);
		if (employeeBean != null && employeeBean.getDesignationBean().getDesignationCode().equals("Clerk")) {
			System.out.println("employee is" + employeeBean.getName());
			System.out.println("ulb is" + employeeBean.getUlbBean().getUlbName());

			VenBean.setActive("true");
			VenBean.setDateOfApplication(new Date().toString());
			VenBean.setEmployeeBean(employeeBean);
			VenBean.setUlbBean(employeeBean.getUlbBean());
			VenBean.setPaymentStatus("Payment Pending");
			VenBean.setApplicationStatus(applicationStatusService.getStatus("Applied"));

			VendorBean response = vendorService.save(VenBean);
			return response;
		} else
			return VenBean;

	}

	@PostMapping(value = "/upload-documents", headers = ("content-type=multipart/*"), consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public VendorBean uploadDocuments(@RequestParam("family_pic") MultipartFile family_pic,
			@RequestParam("id_pic") MultipartFile id_pic, @RequestParam("place_pic") MultipartFile place_pic,
			@RequestParam("cart_pic") MultipartFile cart_pic,
			@RequestParam("vendor_id") int vendor_id,								  
													  @RequestHeader("auth_token") String auth_token
													 ) throws SQLException {
		VendorBean response = new VendorBean();
		/*
		 * String auth_token="89137318-b49b-49e0-aa89-b48f32e825bd";
		 */		EmployeeBean employeeBean = employeeService.findbyAuthToken(auth_token);
		List<AttachedDocumentBean> attachedDocument = new ArrayList<>(0);
		/* response = vendorService.findVendorById(vendor_id); */
		// response.setVendorId(vendor_id);
		String imgPath = null;
		if (employeeBean != null  && employeeBean.getDesignationBean().getDesignationCode().equals("Clerk")) {
			response = vendorService.findVendorById(vendor_id);
			MultipartFile[] attachedfiles = { family_pic, id_pic, place_pic, cart_pic };
		if(response!=null)
		{
			for (MultipartFile file : attachedfiles) {
				if (file.isEmpty()) {

				} else {
					try {
						byte[] bytes = null;
						String ext = null;
						String name = null;

						if (file != null) {
							bytes = file.getBytes();

							File dir = new File(IMAGES_DIR);
							if (!dir.exists())
								dir.mkdirs();
							ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
							name = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."));
						}
						imgPath = System.currentTimeMillis() + "-" + name + "." + ext;
						Path path = Paths.get(IMAGES_DIR + imgPath);
						Files.write(path, bytes);
						AttachedDocumentBean attachedDocumentBean = new AttachedDocumentBean();
						//attachedDocumentBean.setDocumentId(Integer.parseInt(databaseSequenceProvider.getNextSequence("SEQ_attached_document").toString()));
						attachedDocumentBean.setDocumentName(name);
						attachedDocumentBean.setDocumentPath(path.toString());
						attachedDocumentBean.setVendorBean(response);
						// attachedDocumenService.save(attachedDocumentBean);
						attachedDocument.add(attachedDocumentBean);
						// new S3Bucket().uploadFileS3Bucket(imgPath,path.toString());

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}}
			attachedDocumenService.saveAll(attachedDocument);
			String regNumber = generateRegistrationNumber(response);
			response.setRegistrationNo(regNumber);
			ApplicationStatusBean s=applicationStatusService.getStatus("Submitted");
			response.setApplicationStatus(s);
			vendorService.update(response);
			
		}
		return response;

	}

	public String generateRegistrationNumber(VendorBean response) throws SQLException {
		int y = Year.now().getValue();
		String currentYear = (y + "-" + (y + 1)).toString();
		String ulbCode = response.getUlbBean().getUlbCode();
		String sequenceName = format(APP_NUMBER_SEQ_PREFIX,response.getUlbBean().getUlbName().toUpperCase());
		String sequenceNumber = null;
		try {
			/*
			 * sequenceNumber = String.format("%06d", response.getVendorId());
			 */
			 sequenceNumber =String.format("%06d",databaseSequenceProvider.getNextSequence(sequenceName));
		} catch (SQLGrammarException e) {
			
			databaseSequenceCreator.createSequence(sequenceName); 
			  sequenceNumber =
			  String.format("%06d",databaseSequenceProvider.getNextSequence(sequenceName));
			 
		}
		return String.format(APP_NUMBER_FORMAT, ulbCode, currentYear, sequenceNumber);
	}
	
	
	
	@GetMapping(value = "/getvendor_pendingforAproval", headers = "Accept=application/json")
	@ResponseBody
	public List<VendorBean> getVendorPendingforApproval(@RequestHeader("auth_token") String auth_token) throws SQLException {
		List<VendorBean> response =null;
		EmployeeBean employeeBean = employeeService.findbyAuthToken(auth_token);
		
		if(employeeBean!=null)
		{
			response=vendorService.getVendorByEmployeeandStatus(employeeBean,applicationStatusService.getStatus("Submitted"));
		}
		
		return response;

	}
	
	@PostMapping(value = "/approve_vendor", headers = "Accept=application/json")
	@ResponseBody
	public String approveVendor(@Valid @RequestBody final VendorBean vendorBean,@RequestHeader("auth_token") String auth_token) throws SQLException {
		EmployeeBean employeeBean = employeeService.findbyAuthToken(auth_token);
		
			if(employeeBean!=null  && employeeBean.getDesignationBean().getDesignationCode().equals("EO"))
		{
				vendorBean.setDateOfApproval(new Date().toString());
				vendorBean.setApplicationStatus(applicationStatusService.getStatus("Approved"));
				vendorService.updateForApproval(vendorBean);
				return "Approved";
		}
		
			else
				return "Employee does not exists";
		

	}	
	
	@SuppressWarnings("deprecation")
	@PostMapping(value = "/payFee", headers = "Accept=application/json")
	@ResponseBody
	public String payFeeForVendor(@Valid @RequestBody final VendorBean vendorBean,@RequestHeader("auth_token") String auth_token) throws SQLException {
		EmployeeBean employeeBean = employeeService.findbyAuthToken(auth_token);
		
			if(employeeBean!=null)
			
		{
				Date currDate=new Date();
				vendorBean.setPaymentStatus("Payment Done");
				vendorBean.setValidFrom(new Date().toString());
				vendorBean.setValidTill(new Date( currDate.getYear()+1,currDate.getMonth(),currDate.getDate()).toString());
				vendorBean.setApplicationStatus(applicationStatusService.getStatus("Sanctioned"));
				vendorService.updateForFeePayment(vendorBean);
				return "Fee Paid";
		}
			else
				return "Employee does not exists";
		

	}

	@PostMapping(value = "/updateProfile", headers = "Accept=application/json")
	@ResponseBody
	public String updateProfile(@Valid @RequestBody final EmployeeBean employeeBean,@RequestHeader("auth_token") String auth_token) throws SQLException {
	
		EmployeeBean employeeBeanSaved = employeeService.findbyAuthToken(auth_token);

			if(employeeBeanSaved!=null)
		{
				employeeBeanSaved.setPassword(employeeBean.getPassword());
				employeeService.update(employeeBeanSaved);
				
				return "Employee Updated Successfully";
		}
			
			else
				return "Employee does not exists";
		
	

	}
}
