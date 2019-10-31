package com.sv.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sv.app.bean.EmployeeBean;
import com.sv.app.bean.ULBMasterBean;
import com.sv.app.service.EmployeeService;

@RestController
@RequestMapping(value={"/_upset"})
public class PersisterController {

	@Autowired
	EmployeeService employeeService;
	
	 @PostMapping(value="/employee",headers="Accept=application/json")
	 @ResponseBody
	 public EmployeeBean createEmployee(@Valid @RequestBody final EmployeeBean employeeBean) {
		/* String token = UUID.randomUUID().toString(); */
//		 ULBMasterBean mBean = employeeBean.getUlbCode();
		 
		 System.out.println("==============> "+employeeBean);
	  EmployeeBean tasks=null;//employeeService.save(employeeBean);
	
	  return tasks;
	
	 }

}
