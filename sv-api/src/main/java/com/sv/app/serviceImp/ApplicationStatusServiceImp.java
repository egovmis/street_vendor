package com.sv.app.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.ApplicationStatusBean;
import com.sv.app.repository.ApplicationStatusRepository;
import com.sv.app.repository.VendorRepository;
import com.sv.app.service.ApplicationStatusService;

@Service
@Transactional
public class ApplicationStatusServiceImp implements ApplicationStatusService{
	
	@Autowired
	ApplicationStatusRepository applicationStatusRepository;

	@Override
	public ApplicationStatusBean getStatus(String status_code) {
	return (ApplicationStatusBean) applicationStatusRepository.getStatusByCode(status_code);
	}

}
