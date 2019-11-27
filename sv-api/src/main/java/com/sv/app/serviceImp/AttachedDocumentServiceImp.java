package com.sv.app.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.app.bean.AttachedDocumentBean;
import com.sv.app.bean.VendorBean;
import com.sv.app.repository.AttachedDocumentRepository;
import com.sv.app.service.AttachedDocumentService;

@Service
@Transactional
public class AttachedDocumentServiceImp implements AttachedDocumentService{

	@Autowired
	AttachedDocumentRepository attachedDocumentRepository;
	
	@Override
	public void save(AttachedDocumentBean applicationDocsAttached) {
		attachedDocumentRepository.save(applicationDocsAttached);
		
	}

	@Override
	public void saveAll(List<AttachedDocumentBean> attachedDocuments) {
		attachedDocumentRepository.save(attachedDocuments);
		
	}

	@Override
	public List<AttachedDocumentBean> getAttachedDocumentBId(VendorBean vendorBean) {
		return (List<AttachedDocumentBean>) attachedDocumentRepository.getAttachedDocumentById(vendorBean.getVendorId());
	}

	

}
