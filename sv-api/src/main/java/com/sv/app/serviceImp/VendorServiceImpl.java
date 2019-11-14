package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.app.bean.VendorBean;
import com.sv.app.repository.VendorRepository;
import com.sv.app.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	VendorRepository vendorRepository;
	

	@Override
	public List<VendorBean> findVendorByRequestParam(VendorBean vendorBean) {
		return (List<VendorBean>) vendorRepository.findVendorByRequestParam(vendorBean.getVendorId(), vendorBean.getName(), vendorBean.getMobileNo());
	}

	@Override
	public VendorBean save(VendorBean vendorBean) {
		return (VendorBean) vendorRepository.save(vendorBean);
	}
}
