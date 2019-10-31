package com.sv.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sv.app.bean.EmployeeBean;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeBean, Long>{

	@Query("FROM EmployeeBean WHERE name like %:name%")
	public List<EmployeeBean> findbyName(@Param("name")String name);

}
