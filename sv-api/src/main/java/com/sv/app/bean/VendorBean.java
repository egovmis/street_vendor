package com.sv.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name="vendor")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class VendorBean {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="reg_id")
		private long regId;
	
		@Column(name="reg_uuid")
		private String regUuid;
		
		
		@Column(name="unique_application_no")
		private String uniqueApplicationNo;

		@Column(name="name")
		private String name;
		
		@Column(name="dob")
		private String dob;
		
		@Column(name="gender")
		private String gender;
		
		@Column(name="business_type_uuid")
		private String businessTypeUuid;
		
		@Column(name="address")
		private String address;
		
		@Column(name="ulb_name")
		private String ulbName;
		
		@Column(name="opted_vending_category")
		private String optedVendingCategory;
		
		@Column(name="allocated_vending_category")
		private String allocatedVendingCategory;
		
		@Column(name="opted_zone")
		private String optedZone;
		
		@Column(name="allocated_zone")
		private String allocatedZone;
		
		@Column(name="date_of_application")
		private String dateOfApplication;
		
		@Column(name="date_of_approval")
		private String dateOfApproval;
		
		@Column(name="active")
		private String active;
		
		@Column(name="reg_fee_payment_status")
		private String regFeePaymentStatus;
		
		@Column(name="application_status")
		private String applicationStatus;
		
		@Column(name="reg_valid_upto_date")
		private String regValidUptoDate;
		
		@Column(name="remarks")
		private String remarks;
		
		
	}
