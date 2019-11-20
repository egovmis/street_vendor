package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.VendingTimeBean;
import com.sv.app.repository.VendingTimeRepository;
import com.sv.app.service.VendingTimeService;


@Service
@Transactional
public class VendingTimeServiceImp implements VendingTimeService{

	@Autowired
	VendingTimeRepository vendingTimeRepository;

	@Override
	public List<VendingTimeBean> getAllVendingTime() {
		// TODO Auto-generated method stub
		return (List<VendingTimeBean>) vendingTimeRepository.findAll();
	}


}
