package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.PatientBean;
import com.sv.app.repository.PatientRepository;
import com.sv.app.service.PatientService;


@Service
@Transactional
public class PatientServiceImp implements PatientService{

	
	@Autowired
	PatientRepository patientRepository;
	
	@Override
	public List<PatientBean> findAllPatient() {
		// TODO Auto-generated method stub
		return (List<PatientBean>) patientRepository.findAll();
	}

	@Override
	public void addPatient(PatientBean patient) {
		patientRepository.save(patient);
		
	}

}
