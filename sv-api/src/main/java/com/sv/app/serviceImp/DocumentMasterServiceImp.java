package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.DocumentMasterBean;
import com.sv.app.bean.VendingTypeBean;
import com.sv.app.repository.DocumentMasterRepository;
import com.sv.app.repository.VendingTypeRepository;
import com.sv.app.service.DocumentMasterService;
import com.sv.app.service.VendingTypeService;


@Service
@Transactional
public class DocumentMasterServiceImp implements DocumentMasterService{

	@Autowired
	DocumentMasterRepository documentMasterRepository;

	@Override
	public List<DocumentMasterBean> getAllUIDType() {
		// TODO Auto-generated method stub
		return (List<DocumentMasterBean>) documentMasterRepository.findAll();
	}


}
