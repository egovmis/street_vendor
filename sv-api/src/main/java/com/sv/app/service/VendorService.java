package com.sv.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.app.bean.VendorBean;

@Service
public interface VendorService {
	
	public List<VendorBean> findVendorByRequestParam(VendorBean vendorBean);
	
	public VendorBean save(VendorBean vendorBean);

}
