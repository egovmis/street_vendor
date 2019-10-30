package com.sv.app.service;

import com.sv.app.bean.AdminBean;

public interface AdminService {
	
	public AdminBean adminLogin(String email, String password);
	public int setAuthToken(String authToken, String email, String password);
	
	

}
