package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.VendingZoneBean;
import com.sv.app.repository.VendingZoneRepository;
import com.sv.app.service.VendingZoneService;

@Service
@Transactional
public class VendingZoneServiceImp implements VendingZoneService {

	@Autowired
	VendingZoneRepository vendingZoneRepository;

	@Override
	public List<VendingZoneBean> getAllVendingZones() {
		// TODO Auto-generated method stub
		return (List<VendingZoneBean>) vendingZoneRepository.findAll();
	}

}
