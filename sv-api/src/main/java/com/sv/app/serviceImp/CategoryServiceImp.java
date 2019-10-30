package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.CategoryBean;
import com.sv.app.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImp implements CategoryService{

	@Override
	public List<CategoryBean> findAllPhysician() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * @Autowired PhysicianRepository physicianRepository;
	 * 
	 * @Override public List<CategoryBean> findAllPhysician() { // TODO
	 * Auto-generated method stub return (List<CategoryBean>)
	 * physicianRepository.findAll(); }
	 */

}
