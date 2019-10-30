package com.sv.app.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.AdminBean;
import com.sv.app.repository.AdminRepository;
import com.sv.app.service.AdminService;

@Service
@Transactional
public class AdminServiceImp implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public AdminBean adminLogin(String email, String password) {
		return adminRepository.findByLogin(email, password);
	}

	@Override
	public int setAuthToken(String authToken, String email, String password) {
		int userValidate;
		userValidate = adminRepository.setToken(authToken, email, password);
		return userValidate;
	}

}
