package com.sv.app.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empid")
	private long empId;

	@Column(name = "name")
	private String name;

	private String ulbName;
	private String degName;

	@Column(name = "phone_no")
	private String phoneNo;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ulb_code")
	private ULBMasterBean ulbCode;

	@Column(name = "password")
	private String password;

	@Column(name = "active")
	private String active;

	@ManyToOne(optional = false)
	@JoinColumn(name = "designation", referencedColumnName = "designation_code", insertable = false, updatable = false)
	private DesignationBean designationBean;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public ULBMasterBean getUlbCode() {
		return ulbCode;
	}

	public void setUlbCode(ULBMasterBean ulbCode) {
		this.ulbCode = ulbCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public DesignationBean getDesignationBean() {
		return designationBean;
	}

	public void setDesignationBean(DesignationBean designationBean) {
		this.designationBean = designationBean;
	}

	public String getUlbName() {
		return ulbName;
	}

	public void setUlbName(String ulbName) {
		this.ulbName = ulbName;
	}

	public String getDegName() {
		return degName;
	}

	public void setDegName(String degName) {
		this.degName = degName;
	}

	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", name=" + name + ", phoneNo=" + phoneNo + ", ulbCode=" + ulbCode
				+ ", password=" + password + ", active=" + active + ", designationBean=" + designationBean + "]";
	}

}
