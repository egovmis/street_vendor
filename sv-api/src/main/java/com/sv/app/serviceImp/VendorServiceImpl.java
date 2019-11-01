package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.app.bean.VendorBean;
import com.sv.app.repository.VendorRepository;
import com.sv.app.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	VendorRepository vendorRepository;

	@Override
	public List<VendorBean> findAllVendor() {
		// TODO Auto-generated method stub
		return (List<VendorBean>) vendorRepository.findAll();
	}

	@Override
	public VendorBean findVendorById(long id) {
		return (VendorBean) vendorRepository.findOne(id);
	}

	@Override
	public List<VendorBean> findVendorByName(String name) {
		return (List<VendorBean>) vendorRepository.findbyName(name);
	}

	@Override
	public VendorBean save(VendorBean vendorBean) {
		return (VendorBean) vendorRepository.save(vendorBean);
	}

}
