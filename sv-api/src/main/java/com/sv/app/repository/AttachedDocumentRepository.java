package com.sv.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sv.app.bean.AttachedDocumentBean;

public interface AttachedDocumentRepository extends CrudRepository<AttachedDocumentBean, Integer>{
	@Query("FROM AttachedDocumentBean where reg_vendor_id=:reg_vendor_id")
	List<AttachedDocumentBean> getAttachedDocumentById(@Param("reg_vendor_id") int reg_vendor_id);


}
