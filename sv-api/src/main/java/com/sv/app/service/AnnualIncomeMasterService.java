package com.sv.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sv.app.bean.AnnualIncomeMasterBean;

@Service
public interface AnnualIncomeMasterService {
	
	List<AnnualIncomeMasterBean> getAllAnnualIncome();

}
