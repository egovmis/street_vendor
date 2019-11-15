package com.sv.app.service;

import java.util.List;

import com.sv.app.bean.EQMasterBean;

public interface EQService {

	/*
	 * public ApplicationStatusBean adminLogin(String email, String password);
	 * public int setAuthToken(String authToken, String email, String password);
	 */

	List<EQMasterBean> getAllEduQual();

}
