package com.sv.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sv.app.bean.PatientBean;

public interface PatientRepository extends CrudRepository<PatientBean, Long>{

}