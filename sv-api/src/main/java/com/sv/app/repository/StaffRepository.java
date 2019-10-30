package com.sv.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sv.app.bean.StaffBean;

public interface StaffRepository extends CrudRepository<StaffBean, Long>{

}
