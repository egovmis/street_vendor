package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sv.app.bean.EmployeeBean;
import com.sv.app.repository.EmployeeRepository;
import com.sv.app.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeBean> findAllEmployee() {
		// TODO Auto-generated method stub
		return (List<EmployeeBean>) employeeRepository.findAll();
	}

}
