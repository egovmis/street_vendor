package com.sv.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sv.app.bean.EmployeeBean;
import com.sv.app.bean.ULBMasterBean;
import com.sv.app.service.EmployeeService;

@RestController
@RequestMapping(value = { "/_upset" })
public class PersisterController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/createemployee", headers = "Accept=application/json")
	@ResponseBody
	public EmployeeBean createEmployee(@Valid @RequestBody final EmployeeBean employeeBean) {

		EmployeeBean tasks = employeeService.save(employeeBean);

		return tasks;

	}

}
