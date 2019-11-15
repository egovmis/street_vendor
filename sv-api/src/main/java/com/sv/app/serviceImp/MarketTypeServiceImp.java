package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.MktTypeMasterBean;
import com.sv.app.repository.MarketTypeRepository;
import com.sv.app.service.MarketTypeService;


@Service
@Transactional
public class MarketTypeServiceImp implements MarketTypeService{

	@Autowired
	MarketTypeRepository marketTypeRepository;

	@Override
	public List<MktTypeMasterBean> getAllMarketType() {
		// TODO Auto-generated method stub
		return (List<MktTypeMasterBean>) marketTypeRepository.findAll();
	}


}
