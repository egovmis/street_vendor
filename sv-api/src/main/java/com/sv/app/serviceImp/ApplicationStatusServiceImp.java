package com.sv.app.serviceImp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.service.ApplicationStatusService;

@Service
@Transactional
public class ApplicationStatusServiceImp implements ApplicationStatusService{

	/*
	 * @Autowired AdminRepository adminRepository;
	 * 
	 * @Override public ApplicationStatusBean adminLogin(String email, String
	 * password) { return adminRepository.findByLogin(email, password); }
	 * 
	 * @Override public int setAuthToken(String authToken, String email, String
	 * password) { int userValidate; userValidate =
	 * adminRepository.setToken(authToken, email, password); return userValidate; }
	 */

}
