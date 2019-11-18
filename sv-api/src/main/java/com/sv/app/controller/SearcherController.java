package com.sv.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sv.app.bean.AnnualIncomeMasterBean;
import com.sv.app.bean.CategoryMasterBean;
import com.sv.app.bean.DocumentMasterBean;
import com.sv.app.bean.EQMasterBean;
import com.sv.app.bean.EmployeeBean;
import com.sv.app.bean.IncomeCatMasterBean;
import com.sv.app.bean.MktTypeMasterBean;
import com.sv.app.bean.ULBMasterBean;
import com.sv.app.bean.VendingCategoryBean;
import com.sv.app.bean.VendingTypeBean;
import com.sv.app.bean.VendingZoneBean;
import com.sv.app.bean.VendorBean;
import com.sv.app.service.AnnualIncomeMasterService;
import com.sv.app.service.CategoryMasterService;
import com.sv.app.service.DocumentMasterService;
import com.sv.app.service.EQService;
import com.sv.app.service.EmployeeService;
import com.sv.app.service.IncomeCatMasterService;
import com.sv.app.service.MarketTypeService;
import com.sv.app.service.ULBMasterService;
import com.sv.app.service.VendingCategoryService;
import com.sv.app.service.VendingTypeService;
import com.sv.app.service.VendingZoneService;
import com.sv.app.service.VendorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SearcherController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	VendorService vendorService;

	@Autowired
	ULBMasterService ulbMasterService;

	@Autowired
	CategoryMasterService categoryMasterService;

	@Autowired
	IncomeCatMasterService incomeCatMasterService;

	@Autowired
	VendingTypeService vendingTypeService;

	@Autowired
	MarketTypeService marketTypeService;
	
	@Autowired
	DocumentMasterService documentMasterService;

	@Autowired
	VendingZoneService vendingZoneService;

	@Autowired
	VendingCategoryService vendingCategoryService;

	@Autowired
	EQService eQService;

	@Autowired
	AnnualIncomeMasterService annualIncomeMasterService;

	@PostMapping(value = "/login_employee", headers = "Accept=application/json")
	@ResponseBody
	public EmployeeBean getLoginUser(@RequestParam("name") String name, @RequestParam("password") String password) {
		EmployeeBean employeeBean = new EmployeeBean();

		employeeBean = employeeService.findLoginEmployee(name, password);
		int isUserValidate = 0;
		if (employeeBean != null) {
			String authToken = UUID.randomUUID().toString();
			isUserValidate = employeeService.setAuthToken(authToken, name, password);
			if (isUserValidate > 0) {
				employeeBean.setAuthToken(authToken);
				return employeeBean;
			}
		} else {
			return new EmployeeBean();
		}
		return employeeBean;

	}

	@GetMapping(value = "/search_employee", headers = "Accept=application/json")
	@ResponseBody
	public List<EmployeeBean> getUserById(EmployeeBean employeeBean, @RequestHeader("auth_token") String auth_token) {
		employeeBean.setAuthToken(auth_token);
		List<EmployeeBean> response = employeeService.findEmployeeByRequestParam(employeeBean);

		return response;

	}

	@GetMapping(value = "/search_vendor", headers = "Accept=application/json")
	@ResponseBody
	public List<VendorBean> getUserById(VendorBean vendorBean,@RequestHeader("auth_token") String auth_token) {
		List<VendorBean> response = null;
		
		EmployeeBean employeeBean=employeeService.findbyAuthToken(auth_token);
		if(employeeBean!=null)
		{
		
		if (vendorBean.getName() == null && vendorBean.getVendorId()== 0 && vendorBean.getMobileNo()==null)
			response = vendorService.findVendor(employeeBean.getUlbBean());

		else
			response = vendorService.findVendorByRequestParam(vendorBean,employeeBean.getUlbBean());
		}
		
		return response;

	}

	@GetMapping(value = "/search_ulb", headers = "Accept=application/json")
	@ResponseBody
	public List<ULBMasterBean> getULB() {
		List<ULBMasterBean> response = ulbMasterService.getAllUlb();
		return response;

	}

	@GetMapping(value = "/search_category", headers = "Accept=application/json")
	@ResponseBody
	public List<CategoryMasterBean> getCategory() {
		List<CategoryMasterBean> response = categoryMasterService.getAllCategory();
		return response;

	}

	@GetMapping(value = "/search_inc_category", headers = "Accept=application/json")
	@ResponseBody
	public List<IncomeCatMasterBean> getIncCategory() {
		List<IncomeCatMasterBean> response = incomeCatMasterService.getAllIncCategory();
		return response;

	}

	@GetMapping(value = "/search_vending_type", headers = "Accept=application/json")
	@ResponseBody
	public List<VendingTypeBean> getVendingType() {
		List<VendingTypeBean> response = vendingTypeService.getAllVendingType();
		return response;

	}

	@GetMapping(value = "/search_market_type", headers = "Accept=application/json")
	@ResponseBody
	public List<MktTypeMasterBean> getMarketType() {
		List<MktTypeMasterBean> response = marketTypeService.getAllMarketType();
		return response;

	}

	@GetMapping(value = "/search_uid_type", headers = "Accept=application/json")
	@ResponseBody
	public List<DocumentMasterBean> getUIDType() {
		List<DocumentMasterBean> response = documentMasterService.getAllUIDType();
		return response;

	}

	@GetMapping(value = "/search_vending_zone", headers = "Accept=application/json")
	@ResponseBody
	public List<VendingZoneBean> getVendingZones() {
		List<VendingZoneBean> response = vendingZoneService.getAllVendingZones();
		return response;

	}

	@GetMapping(value = "/search_vending_category", headers = "Accept=application/json")
	@ResponseBody
	public List<VendingCategoryBean> getVendingCategory() {
		List<VendingCategoryBean> response = vendingCategoryService.getAllVendingCategory();
		return response;

	}

	@GetMapping(value = "/search_edu_qualification", headers = "Accept=application/json")
	@ResponseBody
	public List<EQMasterBean> getEduQualification() {
		List<EQMasterBean> response = eQService.getAllEduQual();
		return response;

	}
	
	@GetMapping(value = "/search_annual_income", headers = "Accept=application/json")
	@ResponseBody
	public List<AnnualIncomeMasterBean> getAnnualIncome() {
		List<AnnualIncomeMasterBean> response = annualIncomeMasterService.getAllAnnualIncome();
		return response;

	}
}