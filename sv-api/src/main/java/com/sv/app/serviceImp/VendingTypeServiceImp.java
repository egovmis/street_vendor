package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.VendingTypeBean;
import com.sv.app.repository.VendingTypeRepository;
import com.sv.app.service.VendingTypeService;


@Service
@Transactional
public class VendingTypeServiceImp implements VendingTypeService{

	@Autowired
	VendingTypeRepository vendingTypeRepository;

	@Override
	public List<VendingTypeBean> getAllVendingType() {
		// TODO Auto-generated method stub
		return (List<VendingTypeBean>) vendingTypeRepository.findAll();
	}


}
