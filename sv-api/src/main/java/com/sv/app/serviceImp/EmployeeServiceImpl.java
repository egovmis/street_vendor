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
	public List<EmployeeBean> findAllEmployee() {
		// TODO Auto-generated method stub
		return (List<EmployeeBean>) employeeRepository.findAll();
	}

	@Override
	public EmployeeBean findEmployeeById(long id) {
		return (EmployeeBean) employeeRepository.findOne(id);
	}

	@Override
	public List<EmployeeBean> findEmployeeByName(String name) {
		return (List<EmployeeBean>) employeeRepository.findbyName(name);
	}

	@Override
	public EmployeeBean save(EmployeeBean employeeBean) {
		return (EmployeeBean) employeeRepository.save(employeeBean);
	}

}
