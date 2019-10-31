package com.sv.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sv.app.bean.EmployeeBean;

public interface EmployeeRepository extends CrudRepository<EmployeeBean, Long>{

}
