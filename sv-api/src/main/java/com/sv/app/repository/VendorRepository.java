package com.sv.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sv.app.bean.VendorBean;

@Repository
public interface VendorRepository extends CrudRepository<VendorBean, Integer>{

	
	@Query("FROM VendorBean WHERE (vendor_id=:vendor_id OR name =:name OR mobile_no =:mobile_no) and ulb_code=:ulb_code")
	public List<VendorBean> findVendorByRequestParam(@Param("vendor_id")long vendor_id, @Param("name")String name, @Param("mobile_no")String mobile_no, @Param("ulb_code")String ulb_code);

	@Query("FROM VendorBean where ulb_code=:ulb_code")
	public List<VendorBean> findVendor(@Param("ulb_code")String ulb_code);

	@Query("FROM VendorBean where vendor_id=:vendor_id")
	public VendorBean findById(@Param("vendor_id")int vendor_id);

	/*
	 * @Query("select nextval (?)") public int
	 * getNextSequence(@Param("sequenceName")String sequenceName);
	 * 
	 * @Query("create sequence ?") public void
	 * createSequence(@Param("sequenceName")String sequenceName);
	 */

	/*
	 * @Query("UPDATE VendorBean where vendor_id=?") public VendorBean
	 * update(@Param("vendorBean")VendorBean vendorBea);
	 */
}
