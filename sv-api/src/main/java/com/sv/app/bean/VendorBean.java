package com.sv.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name="reg_vendor")
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
		
		@Column(name="ulb_code")
		private String ulbCode;
		
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="opted_vending_category")
		@JsonIgnore
		private CategoryBean optedVendingCategory;
		
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="allocated_vending_category")
		@JsonIgnore
		private CategoryBean allocatedVendingCategory;
		
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="opted_zone")
		@JsonIgnore
		private VendingZoneBean optedZone;
		
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="allocated_zone")
		@JsonIgnore
		private VendingZoneBean allocatedZone;
		
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
		
		public long getRegId() {
			return regId;
		}

		public void setRegId(long regId) {
			this.regId = regId;
		}

		public String getRegUuid() {
			return regUuid;
		}

		public void setRegUuid(String regUuid) {
			this.regUuid = regUuid;
		}

		public String getUniqueApplicationNo() {
			return uniqueApplicationNo;
		}

		public void setUniqueApplicationNo(String uniqueApplicationNo) {
			this.uniqueApplicationNo = uniqueApplicationNo;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getBusinessTypeUuid() {
			return businessTypeUuid;
		}

		public void setBusinessTypeUuid(String businessTypeUuid) {
			this.businessTypeUuid = businessTypeUuid;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getUlbCode() {
			return ulbCode;
		}

		public void setUlbCode(String ulbCode) {
			this.ulbCode = ulbCode;
		}

		public String getDateOfApplication() {
			return dateOfApplication;
		}

		public void setDateOfApplication(String dateOfApplication) {
			this.dateOfApplication = dateOfApplication;
		}

		public String getDateOfApproval() {
			return dateOfApproval;
		}

		public void setDateOfApproval(String dateOfApproval) {
			this.dateOfApproval = dateOfApproval;
		}

		public String getActive() {
			return active;
		}

		public void setActive(String active) {
			this.active = active;
		}

		public String getRegFeePaymentStatus() {
			return regFeePaymentStatus;
		}

		public void setRegFeePaymentStatus(String regFeePaymentStatus) {
			this.regFeePaymentStatus = regFeePaymentStatus;
		}

		public String getApplicationStatus() {
			return applicationStatus;
		}

		public void setApplicationStatus(String applicationStatus) {
			this.applicationStatus = applicationStatus;
		}

		public String getRegValidUptoDate() {
			return regValidUptoDate;
		}

		public void setRegValidUptoDate(String regValidUptoDate) {
			this.regValidUptoDate = regValidUptoDate;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public String getIdentityNumber() {
			return identityNumber;
		}

		public void setIdentityNumber(String identityNumber) {
			this.identityNumber = identityNumber;
		}

		public int getFamilyPicId() {
			return familyPicId;
		}

		public void setFamilyPicId(int familyPicId) {
			this.familyPicId = familyPicId;
		}

		@Column(name="identity_number")
		private String identityNumber;
		
		@Column(name="family_pic_id")
		private int familyPicId;
		
		
	}
