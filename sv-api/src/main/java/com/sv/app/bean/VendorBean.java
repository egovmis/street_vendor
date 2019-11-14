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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vendor")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class VendorBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_id")
	private int vendorId;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "alternate_no")
	private String alternateNo;

	@Column(name = "present_address")
	private String presentAddress;
	
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	@Column(name = "landmark")
	private String landmark;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ulb_code", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)

	private ULBMasterBean ulbBean;
	/*
	 * @Column(name="ulb_code") private String ulbCode;
	 */

	@Column(name = "vending_place")
	private String vendingPlace;

	@Column(name = "vending_category")
	private String vendingCategory;
	
	@Column(name = "vending_type")
	private String vendingType;
	
	@Column(name = "vending_time")
	private String vendingTime;
	
	@Column(name = "market_type")
	private String marketType;

	@Column(name = "uid_no")
	private String uidNo;
	
	@Column(name = "uid_type")
	private String uidType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "registered_by", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)

	private EmployeeBean employeeBean;
	/*
	 * @Column(name="registered_by") private String registeredBy;
	 */

	@Column(name = "issued_date")
	private String issuedDate;

	@Column(name = "valid_from")
	private String validFrom;

	@Column(name = "valid_till")
	private String validTill;
	
	@Column(name = "income_category")
	private String incomeCategory;
	
	@Column(name = "annual_income")
	private String annualIncome;
	
	@Column(name = "registration_no")
	private String registrationNo;
	
	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "status")
	private String status;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAlternateNo() {
		return alternateNo;
	}

	public void setAlternateNo(String alternateNo) {
		this.alternateNo = alternateNo;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public ULBMasterBean getUlbBean() {
		return ulbBean;
	}

	public void setUlbBean(ULBMasterBean ulbBean) {
		this.ulbBean = ulbBean;
	}

	public String getVendingPlace() {
		return vendingPlace;
	}

	public void setVendingPlace(String vendingPlace) {
		this.vendingPlace = vendingPlace;
	}

	public String getVendingCategory() {
		return vendingCategory;
	}

	public void setVendingCategory(String vendingCategory) {
		this.vendingCategory = vendingCategory;
	}

	public String getVendingType() {
		return vendingType;
	}

	public void setVendingType(String vendingType) {
		this.vendingType = vendingType;
	}

	public String getVendingTime() {
		return vendingTime;
	}

	public void setVendingTime(String vendingTime) {
		this.vendingTime = vendingTime;
	}

	public String getMarketType() {
		return marketType;
	}

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

		public CategoryBean getOptedVendingCategory() {
			return optedVendingCategory;
		}

		public void setOptedVendingCategory(CategoryBean optedVendingCategory) {
			this.optedVendingCategory = optedVendingCategory;
		}

		public CategoryBean getAllocatedVendingCategory() {
			return allocatedVendingCategory;
		}

		public void setAllocatedVendingCategory(CategoryBean allocatedVendingCategory) {
			this.allocatedVendingCategory = allocatedVendingCategory;
		}

		public VendingZoneBean getOptedZone() {
			return optedZone;
		}

		public void setOptedZone(VendingZoneBean optedZone) {
			this.optedZone = optedZone;
		}

		public VendingZoneBean getAllocatedZone() {
			return allocatedZone;
		}

		public void setAllocatedZone(VendingZoneBean allocatedZone) {
			this.allocatedZone = allocatedZone;
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

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	public String getUidNo() {
		return uidNo;
	}

	public void setUidNo(String uidNo) {
		this.uidNo = uidNo;
	}

	public String getUidType() {
		return uidType;
	}

	public void setUidType(String uidType) {
		this.uidType = uidType;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public String getIncomeCategory() {
		return incomeCategory;
	}

	public void setIncomeCategory(String incomeCategory) {
		this.incomeCategory = incomeCategory;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	
}
