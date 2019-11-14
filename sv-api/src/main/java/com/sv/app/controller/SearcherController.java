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

import com.sv.app.bean.CategoryBean;
import com.sv.app.bean.CategoryMasterBean;
import com.sv.app.bean.EmployeeBean;
import com.sv.app.bean.IncomeCatMasterBean;
import com.sv.app.bean.ULBMasterBean;
import com.sv.app.bean.VendorBean;
import com.sv.app.service.CategoryMasterService;
import com.sv.app.service.EmployeeService;
import com.sv.app.service.IncomeCatMasterService;
import com.sv.app.service.ULBMasterService;
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

	@PostMapping(value = "/login_employee", headers = "Accept=application/json")
	@ResponseBody
	public EmployeeBean getLoginUser(@RequestParam("name") String name, @RequestParam("password") String password) {
		EmployeeBean employeeBean = new EmployeeBean();
		
		employeeBean = employeeService.findLoginEmployee(name, password);
		int isUserValidate = 0;
		if (employeeBean!=null) {
			String authToken = UUID.randomUUID().toString();
			isUserValidate = employeeService.setAuthToken(authToken, name, password);
			if (isUserValidate>0) {
				employeeBean.setAuthToken(authToken);
				return employeeBean;
			}
		} else {
			return new EmployeeBean();
		}
		return employeeBean;

	}

	/*
	 * @GetMapping(value = "/get",headers = "Accept=application/json")
	 * 
	 * @ResponseBody public List<EmployeeBean> getAllUser() { String token =
	 * UUID.randomUUID().toString(); List<EmployeeBean> tasks =
	 * employeeService.findAllEmployee();
	 * 
	 * return tasks;
	 * 
	 * }
	 */
	@GetMapping(value="/search_employee", headers = "Accept=application/json")
	@ResponseBody
	public List<EmployeeBean> getUserById(EmployeeBean employeeBean, @RequestHeader("auth_token") String auth_token) {
		employeeBean.setAuthToken(auth_token);
		List<EmployeeBean> tasks = employeeService.findEmployeeByRequestParam(employeeBean);

		return tasks;

	}

	/*
	 * @GetMapping(value = "/_byName/{name}", headers = "Accept=application/json")
	 * 
	 * @ResponseBody public List<EmployeeBean> getUserByName(@PathVariable String
	 * name) { String token = UUID.randomUUID().toString(); List<EmployeeBean> tasks
	 * = employeeService.findEmployeeByName(name);
	 * 
	 * return tasks;
	 * 
	 * }
	 */
	@GetMapping(value="/search_vendor", headers = "Accept=application/json")
	@ResponseBody
	public List<VendorBean> getUserById(VendorBean vendorBean) {
		List<VendorBean> tasks = vendorService.findVendorByRequestParam(vendorBean);

		return tasks;

	}
	
	@GetMapping(value="/search_ulb", headers = "Accept=application/json")
	@ResponseBody
	public List<ULBMasterBean> getULB() {
		List<ULBMasterBean> tasks = ulbMasterService.getAllUlb();
		return tasks;

	}
	
	@GetMapping(value="/search_category", headers = "Accept=application/json")
	@ResponseBody
	public List<CategoryMasterBean> getCategory() {
		List<CategoryMasterBean> tasks = categoryMasterService.getAllCategory();
		return tasks;

	}
	
	@GetMapping(value="/search_inc_category", headers = "Accept=application/json")
	@ResponseBody
	public List<IncomeCatMasterBean> getIncCategory() {
		List<IncomeCatMasterBean> tasks = incomeCatMasterService.getAllIncCategory();
		return tasks;

	}
}
