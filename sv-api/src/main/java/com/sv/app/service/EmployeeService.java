package com.sv.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.app.bean.EmployeeBean;

@Service
public interface EmployeeService {
	
	public List<EmployeeBean> findAllEmployee();
	
	public EmployeeBean findEmployeeById(long id);
	
	public List<EmployeeBean> findEmployeeByName(String name);
	
	public EmployeeBean save(EmployeeBean employeeBean);


}
