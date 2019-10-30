package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.StaffBean;
import com.sv.app.repository.StaffRepository;
import com.sv.app.service.StaffService;

@Service
@Transactional
public class StaffServiceImp implements StaffService{
	@Autowired
	StaffRepository staffRepository;
	
	@Override
	public List<StaffBean> findAllStaff() {
		// TODO Auto-generated method stub
		return (List<StaffBean>) staffRepository.findAll();
	}

}
