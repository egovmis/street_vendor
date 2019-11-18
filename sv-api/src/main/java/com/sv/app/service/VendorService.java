package com.sv.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	 * public VendorBean update(VendorBean vendorBean);
	 */
}
