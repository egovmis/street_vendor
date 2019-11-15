package com.sv.app.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="attached_document_master")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AttachedDocumentBean implements Serializable {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="document_id")
		private int documentId;

		@Column(name="document_name")
		private String documentName;

		@Column(name="document_path")
		private String documentPath;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "reg_vendor_id")
		@OnDelete(action = OnDeleteAction.CASCADE)
		private VendorBean vendorBean;

		public int getDocumentId() {
			return documentId;
		}

		public void setDocumentId(int documentId) {
			this.documentId = documentId;
		}

		public String getDocumentName() {
			return documentName;
		}

		public void setDocumentName(String documentName) {
			this.documentName = documentName;
		}

		public String getDocumentPath() {
			return documentPath;
		}

		public void setDocumentPath(String documentPath) {
			this.documentPath = documentPath;
		}

		public VendorBean getVendorBean() {
			return vendorBean;
		}

		public void setVendorBean(VendorBean vendorBean) {
			this.vendorBean = vendorBean;
		}
}
