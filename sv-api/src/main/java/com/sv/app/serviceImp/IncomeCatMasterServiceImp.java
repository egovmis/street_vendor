package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.IncomeCatMasterBean;
import com.sv.app.repository.IncomeCatMasterRepository;
import com.sv.app.service.IncomeCatMasterService;

@Service
@Transactional
public class IncomeCatMasterServiceImp implements IncomeCatMasterService {

	@Autowired
	IncomeCatMasterRepository incomeCatMasterRepository;

	@Override
	public List<IncomeCatMasterBean> getAllIncCategory() {

		return (List<IncomeCatMasterBean>) incomeCatMasterRepository.findAll();
	}

}
