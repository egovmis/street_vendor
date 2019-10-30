package com.sv.app.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



	
	@Entity
	@Table(name="companies")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class CompanyBean {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="company_id")
		private long companyId;
	
		@Column(name="company_name")
		private String companyName;
		
		@Column(name="company_address")
		private String companyAddress;
		
		@Column(name="company_site_name")
		private String companySiteName;
		
		@Column(name="company_url_name")
		private String companyUrlName;
		
		@Column(name="company_support_email")
		private String companySupportEmail;
		
		@Column(name="company_status")
		private String companyStatus;
			
		@Column(name="created")
		@CreationTimestamp
		private Timestamp created;
		
		@Column(name="updated")
		@UpdateTimestamp
		private Timestamp updated;
		
		@OneToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id", nullable = false)
		    @JsonIgnore
		 private UserBean userBean;

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanySiteName() {
		return companySiteName;
	}

	public void setCompanySiteName(String companySiteName) {
		this.companySiteName = companySiteName;
	}

	public String getCompanyUrlName() {
		return companyUrlName;
	}

	public void setCompanyUrlName(String companyUrlName) {
		this.companyUrlName = companyUrlName;
	}

	public String getCompanySupportEmail() {
		return companySupportEmail;
	}

	public void setCompanySupportEmail(String companySupportEmail) {
		this.companySupportEmail = companySupportEmail;
	}

	public String getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	   
	   
}

