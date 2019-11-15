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

import com.sv.app.bean.CategoryMasterBean;
import com.sv.app.bean.EQMasterBean;
import com.sv.app.bean.EmployeeBean;
import com.sv.app.bean.IncomeCatMasterBean;
import com.sv.app.bean.MktTypeMasterBean;
import com.sv.app.bean.ULBMasterBean;
import com.sv.app.bean.VendingCategoryBean;
import com.sv.app.bean.VendingTypeBean;
import com.sv.app.bean.VendingZoneBean;
import com.sv.app.bean.VendorBean;
import com.sv.app.service.CategoryMasterService;
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
	VendingZoneService vendingZoneService;

	@Autowired
	VendingCategoryService vendingCategoryService;

	@Autowired
	EQService eQService;

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
		List<EmployeeBean> tasks = employeeService.findEmployeeByRequestParam(employeeBean);

		return tasks;

	}

	@GetMapping(value = "/search_vendor", headers = "Accept=application/json")
	@ResponseBody
	public List<VendorBean> getUserById(VendorBean vendorBean,@RequestHeader("auth_token") String auth_token) {
		List<VendorBean> tasks = null;
		
		if (vendorBean.getName() == null && vendorBean.getVendorId()== 0 && vendorBean.getMobileNo()==null)
			tasks = vendorService.findVendor();

		else
			tasks = vendorService.findVendorByRequestParam(vendorBean);
		return tasks;

	}

	@GetMapping(value = "/search_ulb", headers = "Accept=application/json")
	@ResponseBody
	public List<ULBMasterBean> getULB() {
		List<ULBMasterBean> tasks = ulbMasterService.getAllUlb();
		return tasks;

	}

	@GetMapping(value = "/search_category", headers = "Accept=application/json")
	@ResponseBody
	public List<CategoryMasterBean> getCategory() {
		List<CategoryMasterBean> tasks = categoryMasterService.getAllCategory();
		return tasks;

	}

	@GetMapping(value = "/search_inc_category", headers = "Accept=application/json")
	@ResponseBody
	public List<IncomeCatMasterBean> getIncCategory() {
		List<IncomeCatMasterBean> tasks = incomeCatMasterService.getAllIncCategory();
		return tasks;

	}

	@GetMapping(value = "/search_vending_type", headers = "Accept=application/json")
	@ResponseBody
	public List<VendingTypeBean> getVendingType() {
		List<VendingTypeBean> tasks = vendingTypeService.getAllVendingType();
		return tasks;

	}

	@GetMapping(value = "/search_market_type", headers = "Accept=application/json")
	@ResponseBody
	public List<MktTypeMasterBean> getMarketType() {
		List<MktTypeMasterBean> tasks = marketTypeService.getAllMarketType();
		return tasks;

	}

	@GetMapping(value = "/search_uid_type", headers = "Accept=application/json")
	@ResponseBody
	public List<MktTypeMasterBean> getUIDType() {
		List<MktTypeMasterBean> tasks = marketTypeService.getAllMarketType();
		return tasks;

	}

	@GetMapping(value = "/search_vending_zone", headers = "Accept=application/json")
	@ResponseBody
	public List<VendingZoneBean> getVendingZones() {
		List<VendingZoneBean> tasks = vendingZoneService.getAllVendingZones();
		return tasks;

	}

	@GetMapping(value = "/search_vending_category", headers = "Accept=application/json")
	@ResponseBody
	public List<VendingCategoryBean> getVendingCategory() {
		List<VendingCategoryBean> tasks = vendingCategoryService.getAllVendingCategory();
		return tasks;

	}

	@GetMapping(value = "/search_edu_qualification", headers = "Accept=application/json")
	@ResponseBody
	public List<EQMasterBean> getEduQualification() {
		List<EQMasterBean> tasks = eQService.getAllEduQual();
		return tasks;

	}
}