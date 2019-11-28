package com.sv.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.app.bean.ApplicationStatusBean;
import com.sv.app.bean.EmployeeBean;
import com.sv.app.bean.ULBMasterBean;
import com.sv.app.bean.VendorBean;

@Service
public interface VendorService {
	
	public List<VendorBean> findVendorByRequestParam(VendorBean vendorBean,ULBMasterBean ulbBean);
	public List<VendorBean> findVendor(ULBMasterBean ulbBean);
	public VendorBean findVendorById(int vendorID);
	public VendorBean save(VendorBean vendorBean);
	/*
	 * public int getNextSequence(String sequenceName); public void
	 * createSequence(String sequenceName);
	 */
	/*
	 * public VendorBean update(VendorBean vendorBean);
	 */
	public List<VendorBean> getVendorByEmployeeandStatus(ULBMasterBean ulbMasterBean, ApplicationStatusBean status);
	public void update(VendorBean response);
	void updateForApproval(VendorBean response);
	void updateForFeePayment(VendorBean response);
	public Boolean searchMobile(String mobile_number,ULBMasterBean ulbBean);
}
