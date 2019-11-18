package com.sv.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sv.app.bean.ApplicationStatusBean;
import com.sv.app.bean.AttachedDocumentBean;

public interface AttachedDocumentRepository extends CrudRepository<AttachedDocumentBean, Long>{


}
