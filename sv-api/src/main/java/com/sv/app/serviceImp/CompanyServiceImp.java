package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.CompanyBean;
import com.sv.app.repository.CompanyRepository;
import com.sv.app.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImp implements CompanyService{
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	public List<CompanyBean> findAllCompany() {
		// TODO Auto-generated method stub
		return (List<CompanyBean>) companyRepository.findAll();
	}

}
