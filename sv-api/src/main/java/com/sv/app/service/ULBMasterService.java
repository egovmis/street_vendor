package com.sv.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.app.bean.ULBMasterBean;

@Service
public interface ULBMasterService{
	/*
	 * public ULBMasterBean addUser(ULBMasterBean userBean); public
	 * List<ULBMasterBean> getUser(); public ULBMasterBean userLogin(String email,
	 * String password); public int setAuthToken(String authToken, String email,
	 * String password); public ULBMasterBean findById(long id); public
	 * ULBMasterBean update(ULBMasterBean userBean); public void deleteUserById(long
	 * id); public ULBMasterBean updatePartially(ULBMasterBean userBean, long id);
	 */
	
	List<ULBMasterBean> getAllUlb();
}
