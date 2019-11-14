package com.sv.app.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "ulb_master")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ULBMasterBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ulb_code")
	private String ulbCode;

	@Column(name = "ulb_name")
	private String ulbName;

	@Column(name = "district")
	private String district;

	@Column(name = "type")
	private String type;

	@Column(name = "DDR")
	private String DDR;

	@Column(name = "name_of_eo")
	private String nameOfEo;

	@Column(name = "contact_no")
	private String contact_no;

	@Column(name = "password")
	private String password;


	// =================Setter and Getter ================//

	public String getUlbCode() {
		return ulbCode;
	}

	public void setUlbCode(String ulbCode) {
		this.ulbCode = ulbCode;
	}

	public String getUlbName() {
		return ulbName;
	}

	public void setUlbName(String ulbName) {
		this.ulbName = ulbName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDDR() {
		return DDR;
	}

	public void setDDR(String dDR) {
		DDR = dDR;
	}

	public String getNameOfEo() {
		return nameOfEo;
	}

	public void setNameOfEo(String nameOfEo) {
		this.nameOfEo = nameOfEo;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public ULBMasterBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ULBMasterBean(String ulbCode, String ulbName, String district, String type, String dDR, String nameOfEo,
			String contact_no, String password, String amrut_town) {
		super();
		this.ulbCode = ulbCode;
		this.ulbName = ulbName;
		this.district = district;
		this.type = type;
		DDR = dDR;
		this.nameOfEo = nameOfEo;
		this.contact_no = contact_no;
		this.password = password;
	}

	
}
