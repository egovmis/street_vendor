package com.sv.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sv.app.bean.ApplicationStatusBean;

public interface ApplicationStatusRepository extends CrudRepository<ApplicationStatusBean, Long>{

	@Query("FROM ApplicationStatusBean where status_code=:status_code")
	public ApplicationStatusBean getStatusByCode(@Param("status_code")String status_code);
	
	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE AdminBean SET auth_token = ? WHERE email = ? AND password= ?")
	 * public int setToken(@Param("auth_token") String authToken, @Param("email")
	 * String email, @Param("password") String password);
	 * 
	 * @Query("FROM AdminBean WHERE email = ? AND password= ?") public
	 * ApplicationStatusBean findByLogin(@Param("email") String
	 * email, @Param("password") String password);
	 */
}
