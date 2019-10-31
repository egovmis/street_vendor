package com.sv.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sv.app.bean.EmployeeBean;
import com.sv.app.service.EmployeeService;


@RestController
@RequestMapping(value={"/_search"})
public class SearcherController {
	
	@Autowired
	EmployeeService employeeService;
	
	 @GetMapping(headers="Accept=application/json")
	 @ResponseBody
	 public List<EmployeeBean> getAllUser() {
		/* String token = UUID.randomUUID().toString(); */
	  List<EmployeeBean> tasks=employeeService.findAllEmployee();
	
	  return tasks;
	
	 }

	 
	 @GetMapping(value="/{id}", headers="Accept=application/json")
	 @ResponseBody
	 public EmployeeBean getUserById(@PathVariable long id) {
		/* String token = UUID.randomUUID().toString(); */
	  EmployeeBean tasks=employeeService.findEmployeeById(id);
	
	  return tasks;
	
	 }
	 
	 
	 @GetMapping(value="/_byName/{name}", headers="Accept=application/json")
	 @ResponseBody
	 public List<EmployeeBean> getUserByName(@PathVariable String name) {
		/* String token = UUID.randomUUID().toString(); */
	  List<EmployeeBean> tasks=employeeService.findEmployeeByName(name);
	
	  return tasks;
	
	 }
}
