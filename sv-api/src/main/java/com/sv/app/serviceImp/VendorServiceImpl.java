package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.app.bean.ULBMasterBean;
import com.sv.app.bean.VendorBean;
import com.sv.app.repository.VendorRepository;
import com.sv.app.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	VendorRepository vendorRepository;
	@Override
	public List<VendorBean> findVendor(ULBMasterBean ulbBean) {
		return (List<VendorBean>) vendorRepository.findVendor(ulbBean.getUlbCode());
	}

	@Override
	public List<VendorBean> findVendorByRequestParam(VendorBean vendorBean,ULBMasterBean ulbBean) {
		return (List<VendorBean>) vendorRepository.findVendorByRequestParam(vendorBean.getVendorId(), vendorBean.getName(), vendorBean.getMobileNo(),ulbBean.getUlbCode());
	}

	@Override
	public VendorBean save(VendorBean vendorBean) {
		return (VendorBean) vendorRepository.save(vendorBean);
	}

	@Override
	public VendorBean findVendorById(int vendorID) {
		return (VendorBean) vendorRepository.findById(vendorID);
	}

	/*
	 * @Override public VendorBean update(VendorBean vendorBean) { return
	 * (VendorBean) vendorRepository.update(vendorBean); }
	 */
}
