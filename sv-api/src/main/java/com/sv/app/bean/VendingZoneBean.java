package com.sv.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vending_zone_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class VendingZoneBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vending_zone_code")
	private String vendingZoneCode;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "ulb_code", nullable = false)
	@JsonIgnore
	private ULBMasterBean ulbMasterBean;

	@Column(name = "location")
	private String location;

	public String getVendingZoneCode() {
		return vendingZoneCode;
	}

	public void setVendingZoneCode(String vendingZoneCode) {
		this.vendingZoneCode = vendingZoneCode;
	}

	public ULBMasterBean getUlbMasterBean() {
		return ulbMasterBean;
	}

	public void setUlbMasterBean(ULBMasterBean ulbMasterBean) {
		this.ulbMasterBean = ulbMasterBean;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
