package com.sv.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sv.app.bean.ApplicationStatusBean;

public interface ApplicationStatusRepository extends CrudRepository<ApplicationStatusBean, Long>{

	@Query("FROM ApplicationStatusBean where status_code=:status_code")
	public ApplicationStatusBean getStatusByCode(@Param("status_code")String status_code);

	@Query("FROM ApplicationStatusBean")
	public List<ApplicationStatusBean> getAllStatus();
	

}
