package com.sv.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sv.app.bean.FamilyMemberBean;

public interface FamilyMasterRepository extends CrudRepository<FamilyMemberBean, Long>{

}
