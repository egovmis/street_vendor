package com.sv.app.service;

import java.util.List;

import com.sv.app.bean.PatientBean;

public interface PatientService {

	
	  public void addPatient(PatientBean patient); //public List<PatientBean>
	 /* getPatientList(); public PatientBean patientLogin(String email, String
	 * password); public int setAuthToken(String authToken, String email, String
	 * password); public PatientBean findById(long id); public PatientBean
	 * update(PatientBean patient, long l); public void deleteUserById(long id);
	 * public PatientBean updatePartially(PatientBean patient, long id);
	 */
	public List<PatientBean> findAllPatient();
}