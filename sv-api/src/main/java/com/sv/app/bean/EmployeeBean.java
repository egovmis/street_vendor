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
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empid")
	private int empId;

	@Column(name = "name")
	private String name;

	@Column(name = "phone_no")
	private String phoneNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ulb_code", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)

	private ULBMasterBean ulbBean;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "designation_code", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DesignationBean designationBean;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "designation_code") private DesignationBean
	 * designationBean;
	 */

	@Column(name = "password")
	private String password;

	@Column(name = "auth_token")
	private String authToken;

	@Column(name = "active")
	private String active;

	// =====Setter and Getter============//

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
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

	public ULBMasterBean getUlbBean() {
		return ulbBean;
	}

	public void setUlbBean(ULBMasterBean ulbBean) {
		this.ulbBean = ulbBean;
	}

	/*
	 * public DesignationBean getDesignationBean() { return designationBean; }
	 * 
	 * public void setDesignationBean(DesignationBean designationBean) {
	 * this.designationBean = designationBean; }
	 */

	/*
	 * public List<ULBMasterBean> getUlbBean() { return ulbBean; }
	 * 
	 * public void setUlbBean(List<ULBMasterBean> ulbBean) { this.ulbBean = ulbBean;
	 * }
	 */

	public DesignationBean getDesignationBean() {
		return designationBean;
	}

	public void setDesignationBean(DesignationBean designationBean) {
		this.designationBean = designationBean;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public EmployeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", name=" + name + ", phoneNo=" + phoneNo + ", password=" + password
				+ ", authToken=" + authToken + ", active=" + active + "]";
	}

}
