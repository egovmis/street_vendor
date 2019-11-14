package com.sv.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.app.bean.EmployeeBean;

@Service
public interface EmployeeService {

	public EmployeeBean findLoginEmployee(String name, String password);

	public int setAuthToken(String authToken, String name, String password);

//    public List<EmployeeBean> findAllEmployee(String email, String password);

//	public EmployeeBean findEmployeeById(int id);
	
	public List<EmployeeBean> findEmployeeByRequestParam(EmployeeBean employeeBean);

//	public List<EmployeeBean> findEmployeeByName(String name);

	public EmployeeBean save(EmployeeBean employeeBean);

}
