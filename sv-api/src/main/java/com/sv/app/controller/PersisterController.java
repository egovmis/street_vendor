package com.sv.app.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sv.app.bean.AttachedDocumentBean;
import com.sv.app.bean.EmployeeBean;
import com.sv.app.bean.VendorBean;
import com.sv.app.service.AttachedDocumentService;
import com.sv.app.service.EmployeeService;
import com.sv.app.service.VendorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersisterController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	VendorService vendorService;

	@Autowired
	AttachedDocumentService attachedDocumenService;

	@Value("${document.path}")
	private String IMAGES_DIR;

	@PostMapping(value = "/save", headers = "Accept=application/json")
	@ResponseBody
	public EmployeeBean createEmployee(@Valid @RequestBody final EmployeeBean employeeBean) {
		EmployeeBean empBean = employeeBean;
		EmployeeBean response = employeeService.save(empBean);
		return response;
	}

	@PostMapping(value = "/reg-vendor", headers = "Accept=application/json")
	@ResponseBody
	public VendorBean registerVendor(@Valid @RequestBody final VendorBean vendorBean) {
		VendorBean VenBean = vendorBean;
		VendorBean response = vendorService.save(VenBean);
		return response;

	}
	
	@PostMapping(value = "/upload-documents")
	@ResponseBody
	public VendorBean uploadDocuments(@RequestParam("family_pic") MultipartFile family_pic, @RequestParam("id_pic") MultipartFile id_pic, @RequestParam("place_pic") MultipartFile place_pic, @RequestParam("cart_pic") MultipartFile cart_pic, @RequestParam("vendor_id") int vendor_id) {
	VendorBean response=new VendorBean();
	List<AttachedDocumentBean> attachedDocument= new ArrayList<>(0);
	response=vendorService.findVendorById(vendor_id);
	//response.setVendorId(vendor_id);
	String imgPath = null;
	MultipartFile[] attachedfiles= {family_pic,id_pic,place_pic,cart_pic};
	int i=attachedfiles.length;
	if(response!=null)
	{
	for(MultipartFile file:attachedfiles)
	{
	if (file.isEmpty()) {

	}
	else
	{
	try {

	byte[] bytes = file.getBytes();
	File dir = new File(IMAGES_DIR);
	if (!dir.exists())
	dir.mkdirs();
	String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
	String name=file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf("."));
	imgPath = System.currentTimeMillis() +"-" +name+"." + ext;
	Path path = Paths.get(IMAGES_DIR + imgPath);
	Files.write(path, bytes);
	AttachedDocumentBean attachedDocumentBean= new AttachedDocumentBean();
	attachedDocumentBean.setDocumentName(name);
	attachedDocumentBean.setDocumentPath(path.toString());
	attachedDocumentBean.setVendorBean(response);
	attachedDocumenService.save(attachedDocumentBean);
	//attachedDocument.add(attachedDocumentBean);
//		new S3Bucket().uploadFileS3Bucket(imgPath,path.toString());
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	}
	}
	//response.setAttachedDocument(attachedDocument);
		/* response.setRegistrationNo(registrationNo); */
	return response;

	}
}
