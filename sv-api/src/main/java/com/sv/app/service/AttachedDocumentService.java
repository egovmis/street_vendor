package com.sv.app.service;

import java.util.List;

import com.sv.app.bean.AttachedDocumentBean;
import com.sv.app.bean.VendorBean;

public interface AttachedDocumentService {

	void save(AttachedDocumentBean applicationDocsAttached);

	void saveAll(List<AttachedDocumentBean> attachedDocuments);
	
	public  List<AttachedDocumentBean> getAttachedDocumentBId(VendorBean vendorBean);

}
