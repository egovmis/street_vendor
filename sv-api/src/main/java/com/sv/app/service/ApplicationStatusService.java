package com.sv.app.service;

import java.util.List;

import com.sv.app.bean.ApplicationStatusBean;

public interface ApplicationStatusService {
	
	/*
	 * public ApplicationStatusBean adminLogin(String email, String password);
	 * public int setAuthToken(String authToken, String email, String password);
	 */
	public List<ApplicationStatusBean> getAllStatus();

	public ApplicationStatusBean getStatus(String status_code);

}
