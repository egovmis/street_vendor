package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.VendingCategoryBean;
import com.sv.app.repository.VendingCategoryRepository;
import com.sv.app.service.VendingCategoryService;

@Service
@Transactional
public class VendingCategoryServiceImp implements VendingCategoryService{
	@Autowired
	VendingCategoryRepository vendingCategoryRepository;

	@Override
	public List<VendingCategoryBean> getAllVendingCategory() {
		// TODO Auto-generated method stub
		return  (List<VendingCategoryBean>)vendingCategoryRepository.findAll();
	}


	/*
	 * @Autowired PhysicianRepository physicianRepository;
	 * 
	 * @Override public List<CategoryBean> findAllPhysician() { // TODO
	 * Auto-generated method stub return (List<CategoryBean>)
	 * physicianRepository.findAll(); }
	 */

}
