package com.sv.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.app.bean.IncomeCatMasterBean;

@Service
public interface IncomeCatMasterService {
	
	List<IncomeCatMasterBean> getAllIncCategory();

}
