package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.PhysicianBean;
import com.sv.app.repository.PhysicianRepository;
import com.sv.app.service.PhysicianService;

@Service
@Transactional
public class PhysicianServiceImp implements PhysicianService{
	
	@Autowired
	PhysicianRepository physicianRepository;
	
	@Override
	public List<PhysicianBean> findAllPhysician() {
		// TODO Auto-generated method stub
		return (List<PhysicianBean>) physicianRepository.findAll();
	}

}