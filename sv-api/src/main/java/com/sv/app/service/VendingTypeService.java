package com.sv.app.service;

import java.util.List;

import com.sv.app.bean.VendingTypeBean;

public interface VendingTypeService {

	/*
	 * public ApplicationStatusBean adminLogin(String email, String password);
	 * public int setAuthToken(String authToken, String email, String password);
	 */

	List<VendingTypeBean> getAllVendingType();

}
