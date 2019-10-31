package com.sv.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sv.app.bean.ApplicationStatusBean;

public interface ApplicationStatusRepository extends CrudRepository<ApplicationStatusBean, Long>{
	
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
