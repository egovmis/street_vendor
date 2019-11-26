package com.sv.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sv.app.bean.VendingCategoryBean;
import com.sv.app.bean.VendingZoneBean;

public interface VendingCategoryRepository extends CrudRepository<VendingCategoryBean, Long>{


	@Query("FROM VendingCategoryBean WHERE category_name=:category_name")
	public VendingCategoryBean findByName(@Param("category_name")String category_name);

}
