package com.sv.app.service;

import java.util.List;

import com.sv.app.bean.AttachedDocumentBean;

public interface AttachedDocumentService {

	void save(AttachedDocumentBean applicationDocsAttached);
	
	void saveAll(List<AttachedDocumentBean> attachedDocuments);
	/*
	 * public ApplicationStatusBean adminLogin(String email, String password);
	 * public int setAuthToken(String authToken, String email, String password);
	 */
	

}
