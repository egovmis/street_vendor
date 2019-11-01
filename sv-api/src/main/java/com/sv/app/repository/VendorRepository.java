package com.sv.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sv.app.bean.VendorBean;

@Repository
public interface VendorRepository extends CrudRepository<VendorBean, Long>{

	@Query("FROM VendorBean WHERE name like %:name%")
	public List<VendorBean> findbyName(@Param("name")String name);

}
