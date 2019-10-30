package com.sv.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sv.app.bean.CategoryBean;

public interface CategoryRepository extends CrudRepository<CategoryBean, Long>{

}
