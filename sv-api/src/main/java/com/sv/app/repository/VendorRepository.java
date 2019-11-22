package com.sv.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.VendorBean;

@Repository
public interface VendorRepository extends CrudRepository<VendorBean, Integer>{

	  @Modifying
	  @Transactional
	@Query("update VendorBean set application_status=:application_status WHERE vendor_id=:vendor_id")
	public void update(@Param("vendor_id")int vendor_id, @Param("application_status")String application_status);
	
	  @Modifying
	  @Transactional
	@Query("update VendorBean set application_status=:application_status,allocated_zone=:vending_zone_code,allocated_vending_category=:vending_category_name,date_of_aproval=:date_of_approval WHERE vendor_id=:vendor_id")
	public void updateForApproval(@Param("vendor_id")int vendor_id, @Param("application_status")String application_status,@Param("vending_zone_code")String vending_zone_code,@Param("vending_category_name")String vending_category_name,
			@Param("date_of_approval")String date_of_approval);
	  
	  @Modifying
	  @Transactional
	@Query("update VendorBean set application_status=:application_status,valid_from=:valid_from,valid_till=:valid_till,payment_status=:payment_status WHERE vendor_id=:vendor_id")
	public void updateForFeePayment(@Param("vendor_id")int vendor_id, @Param("application_status")String application_status,@Param("valid_from")String valid_from,@Param("valid_till")String valid_till,
			@Param("payment_status")String payment_status);
	
	
	  
	@Query("FROM VendorBean WHERE (vendor_id=:vendor_id OR name =:name OR mobile_no =:mobile_no) and ulb_code=:ulb_code")
	public List<VendorBean> findVendorByRequestParam(@Param("vendor_id")long vendor_id, @Param("name")String name, @Param("mobile_no")String mobile_no, @Param("ulb_code")String ulb_code);

	@Query("FROM VendorBean where ulb_code=:ulb_code")
	public List<VendorBean> findVendor(@Param("ulb_code")String ulb_code);

	@Query("FROM VendorBean where vendor_id=:vendor_id")
	public VendorBean findById(@Param("vendor_id")int vendor_id);

	@Query("FROM VendorBean WHERE registered_by=:emp_id and application_status=:status")
	public List<VendorBean> getVendorByEmployeeandStatus(@Param("emp_id")int emp_id, @Param("status")String status);

}
