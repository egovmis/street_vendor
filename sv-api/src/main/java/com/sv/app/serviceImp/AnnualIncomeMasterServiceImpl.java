package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.AnnualIncomeMasterBean;
import com.sv.app.repository.AnnualIncomeMasterRepository;
import com.sv.app.service.AnnualIncomeMasterService;

@Service
@Transactional
public class AnnualIncomeMasterServiceImpl implements AnnualIncomeMasterService{
	
	@Autowired
	AnnualIncomeMasterRepository annualIncomeMasterRepository;

	@Override
	public List<AnnualIncomeMasterBean> getAllAnnualIncome() {
		// TODO Auto-generated method stub
		return (List<AnnualIncomeMasterBean>) annualIncomeMasterRepository.findAll();
	}

}
