package com.sv.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sv.app.bean.VendorBean;

@Repository
public interface VendorRepository extends CrudRepository<VendorBean, Integer>{

	
	@Query("FROM VendorBean WHERE (vendor_id=? OR name =? OR mobile_no =?)")
	public List<VendorBean> findVendorByRequestParam(@Param("vendor_id")long vendor_id, @Param("name")String name, @Param("mobile_no")String mobile_no);

	@Query("FROM VendorBean")
	public List<VendorBean> findVendor();


}
