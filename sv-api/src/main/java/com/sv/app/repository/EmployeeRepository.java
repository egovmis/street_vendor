package com.sv.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.EmployeeBean;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeBean, Integer>{
	
	  @Modifying
	    @Transactional
	@Query("UPDATE EmployeeBean SET auth_token=? WHERE name=? AND password=?")
	public int setAuthToken(@Param("auth_token")String auth_token, @Param("name")String name, @Param("password")String password);
	

	@Query("FROM EmployeeBean WHERE name=? AND password=?")
	public EmployeeBean loginValidate(@Param("name")String name, @Param("password")String password);

	
	@Query("FROM EmployeeBean WHERE (empid=? OR name =? OR phone_no =? OR password= ?) AND auth_token=?")
	public List<EmployeeBean> findEmployeeByRequestParam(@Param("empid")int empid,@Param("name")String name,@Param("mobileNo")String mobileNo,@Param("password")String password, @Param("auth_token")String auth_token);

	@Query("FROM EmployeeBean WHERE auth_token=?")
	public EmployeeBean findByAuthToken(@Param("auth_token")String auth_token);
}
