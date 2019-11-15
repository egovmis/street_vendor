package com.sv.app.service;

import java.util.List;

import com.sv.app.bean.VendingZoneBean;

public interface VendingZoneService {
	
	/*
	 * public ApplicationStatusBean adminLogin(String email, String password);
	 * public int setAuthToken(String authToken, String email, String password);
	 */
	List<VendingZoneBean> getAllVendingZones();


}
