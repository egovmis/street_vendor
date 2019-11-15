package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.EQMasterBean;
import com.sv.app.repository.EQRepository;
import com.sv.app.service.EQService;


@Service
@Transactional
public class EQServiceImp implements EQService{

	@Autowired
	EQRepository eQRepository;

	@Override
	public List<EQMasterBean> getAllEduQual() {
		// TODO Auto-generated method stub
		return (List<EQMasterBean>) eQRepository.findAll();
	}


}
