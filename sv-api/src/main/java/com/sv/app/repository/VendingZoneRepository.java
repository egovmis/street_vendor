package com.sv.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sv.app.bean.VendingZoneBean;

public interface VendingZoneRepository extends CrudRepository<VendingZoneBean, Long>{

	@Query("FROM VendingZoneBean WHERE vending_zone_code=:code")
	public VendingZoneBean findByCode(@Param("code")String code);

}
