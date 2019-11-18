package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.app.bean.EmployeeBean;
import com.sv.app.repository.EmployeeRepository;
import com.sv.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public int setAuthToken(String authToken, String name, String password) {
		// TODO Auto-generated method stub
		try
		{
			return (int)employeeRepository.setAuthToken(authToken, name, password);
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}

	@Override
	public EmployeeBean findLoginEmployee(String name, String password) {
		return employeeRepository.loginValidate(name, password);
			}
	
	/*
	 * @Override public List<EmployeeBean> findAllEmployee() { // TODO
	 * Auto-generated method stub return (List<EmployeeBean>)
	 * employeeRepository.findAll(); }
	 */

	@Override
	public List<EmployeeBean> findEmployeeByRequestParam(EmployeeBean employeeBean) {
		return (List<EmployeeBean>) employeeRepository.findEmployeeByRequestParam(employeeBean.getEmpId(), employeeBean.getName(), employeeBean.getPhoneNo(), employeeBean.getPassword(), employeeBean.getAuthToken());
	}

	
	/*
	 * @Override public EmployeeBean findEmployeeById(int id) { return
	 * (EmployeeBean) employeeRepository.findOne(id); }
	 * 
	 * @Override public List<EmployeeBean> findEmployeeByName(String name) { return
	 * (List<EmployeeBean>) employeeRepository.findbyName(name); }
	 */

	@Override
	public EmployeeBean save(EmployeeBean employeeBean) {
		return (EmployeeBean) employeeRepository.save(employeeBean);
	}

	@Override
	public EmployeeBean findbyAuthToken(String auth_token) {
		return (EmployeeBean) employeeRepository.findByAuthToken(auth_token);
	}
	

}
