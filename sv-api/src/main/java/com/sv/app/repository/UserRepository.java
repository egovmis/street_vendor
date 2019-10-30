package com.sv.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.UserBean;



public interface UserRepository extends CrudRepository<UserBean, Long>{
	
		
	    @Modifying(clearAutomatically = true)
	    @Transactional
	    @Query("UPDATE UserBean SET auth_token = ? WHERE email = ? AND password= ?")
	    public int setToken(@Param("auth_token") String authToken, @Param("email") String email, @Param("password") String password);

	    @Query("FROM UserBean WHERE email = ? AND password= ?")
	    public UserBean findByLogin(@Param("email") String email, @Param("password") String password);
	
}



/*
 * @Query("FROM Author WHERE firstName = ?1") List<Author>
 * findByFirstName(String firstName);
 * 
 * @Query("SELECT a FROM Author a WHERE firstName = ?1 AND lastName = ?2")
 * List<Author> findByFirstNameAndLastName(String firstName, String lastName);
 */