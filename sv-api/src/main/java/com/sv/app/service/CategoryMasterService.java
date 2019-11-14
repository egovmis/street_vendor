package com.sv.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.app.bean.CategoryMasterBean;

@Service
public interface CategoryMasterService {
	
	List<CategoryMasterBean> getAllCategory();

}
