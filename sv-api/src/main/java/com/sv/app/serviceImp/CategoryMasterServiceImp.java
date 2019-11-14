package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.CategoryMasterBean;
import com.sv.app.repository.CategoryMasterRepository;
import com.sv.app.service.CategoryMasterService;

@Service
@Transactional
public class CategoryMasterServiceImp implements CategoryMasterService {

	@Autowired
	CategoryMasterRepository categoryMasterRepository;

	@Override
	public List<CategoryMasterBean> getAllCategory() {
		return (List<CategoryMasterBean>) categoryMasterRepository.findAll();
	}

}
