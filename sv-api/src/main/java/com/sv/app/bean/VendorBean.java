package com.sv.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vendor")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class VendorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_id")
	private int vendorId;

	@Column(name = "name")
	private String name;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "email")
	private String email;

	@Column(name = "dob")
	private String dob;

	@Column(name = "gender")
	private String gender;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "alternate_no")
	private String alternateNo;

	@Column(name = "present_address")
	private String presentAddress;

	@Column(name = "permanent_address")
	private String permanentAddress;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_category", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CategoryMasterBean vendorCategory;

	@Column(name = "current_landmark")
	private String currLandmark;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ulb_code", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ULBMasterBean ulbBean;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vending_type", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private VendingTypeBean vendingType;

	@Column(name = "vending_time")
	private String vendingTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "market_type", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private MktTypeMasterBean marketType;

	@Column(name = "uid_no")
	private String uidNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid_type", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DocumentMasterBean uidType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "registered_by", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EmployeeBean employeeBean;

	@Column(name = "issued_date")
	private String issuedDate;

	@Column(name = "valid_from")
	private String validFrom;

	@Column(name = "valid_till")
	private String validTill;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "income_category", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private IncomeCatMasterBean incomeCategory;

	@Column(name = "annual_income")
	private String annualIncome;

	@Column(name = "registration_no")
	private String registrationNo;

	@Column(name = "payment_status")
	private String paymentStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_status", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ApplicationStatusBean applicationStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opted_vending_category", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private VendingCategoryBean optedVendingCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "allocated_vending_category")
	private VendingCategoryBean allocatedVendingCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opted_zone", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private VendingZoneBean optedZone;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "allocated_zone")
	private VendingZoneBean allocatedZone;

	@Column(name = "current_vending_place")
	private String currentVendingPlace;

	@Column(name = "years_engagedin_vending")
	private Float yearsEngagedinVending;

	@Column(name = "monthly_income_from_vending")
	private String monthlyIncomefromVending;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "qualification")
	private EQMasterBean qualification;

	@Column(name = "date_of_application")
	private String dateOfApplication;

	@Column(name = "date_of_approval")
	private String dateOfApproval;

	@Column(name = "active")
	private String active;
	/*
	 * @OrderBy("document_id")
	 * 
	 * @OneToMany(mappedBy = "vendorBean", cascade = CascadeType.ALL, fetch
	 * =FetchType.LAZY) private List<AttachedDocumentBean> attachedDocument = new
	 * ArrayList<>(0);
	 */
	/*
	 * @OrderBy("id")
	 * 
	 * @OneToMany(mappedBy = "vendor_id", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<FamilyMemberBean> familyMembers = new
	 * ArrayList<>(0);
	 */

	public int getVendorId() {
		return vendorId;
	}

	public MktTypeMasterBean getMarketType() {
		return marketType;
	}

	public void setMarketType(MktTypeMasterBean marketType) {
		this.marketType = marketType;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public CategoryMasterBean getVendorCategory() {
		return vendorCategory;
	}

	public void setVendorCategory(CategoryMasterBean vendorCategory) {
		this.vendorCategory = vendorCategory;
	}

	public String getCurrLandmark() {
		return currLandmark;
	}

	public void setCurrLandmark(String currLandmark) {
		this.currLandmark = currLandmark;
	}

	public ULBMasterBean getUlbBean() {
		return ulbBean;
	}

	public void setUlbBean(ULBMasterBean ulbBean) {
		this.ulbBean = ulbBean;
	}

	public VendingTypeBean getVendingType() {
		return vendingType;
	}

	public void setVendingType(VendingTypeBean vendingType) {
		this.vendingType = vendingType;
	}

	public String getVendingTime() {
		return vendingTime;
	}

	public void setVendingTime(String vendingTime) {
		this.vendingTime = vendingTime;
	}

	public MktTypeMasterBean getMktTypeMasterBean() {
		return marketType;
	}

	public void setMktTypeMasterBean(MktTypeMasterBean marketType) {
		this.marketType = marketType;
	}

	public String getUidNo() {
		return uidNo;
	}

	public void setUidNo(String uidNo) {
		this.uidNo = uidNo;
	}

	public DocumentMasterBean getUidType() {
		return uidType;
	}

	public void setUidType(DocumentMasterBean uidType) {
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

	public IncomeCatMasterBean getIncomeCategory() {
		return incomeCategory;
	}

	public void setIncomeCategory(IncomeCatMasterBean incomeCategory) {
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

	public ApplicationStatusBean getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatusBean applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public VendingCategoryBean getOptedVendingCategory() {
		return optedVendingCategory;
	}

	public void setOptedVendingCategory(VendingCategoryBean optedVendingCategory) {
		this.optedVendingCategory = optedVendingCategory;
	}

	public VendingCategoryBean getAllocatedVendingCategory() {
		return allocatedVendingCategory;
	}

	public void setAllocatedVendingCategory(VendingCategoryBean allocatedVendingCategory) {
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

	public String getCurrentVendingPlace() {
		return currentVendingPlace;
	}

	public void setCurrentVendingPlace(String currentVendingPlace) {
		this.currentVendingPlace = currentVendingPlace;
	}

	public Float getYearsEngagedinVending() {
		return yearsEngagedinVending;
	}

	public void setYearsEngagedinVending(Float yearsEngagedinVending) {
		this.yearsEngagedinVending = yearsEngagedinVending;
	}

	public String getMonthlyIncomefromVending() {
		return monthlyIncomefromVending;
	}

	public void setMonthlyIncomefromVending(String monthlyIncomefromVending) {
		this.monthlyIncomefromVending = monthlyIncomefromVending;
	}

	public EQMasterBean getQualification() {
		return qualification;
	}

	public void setQualification(EQMasterBean qualification) {
		this.qualification = qualification;
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

}
