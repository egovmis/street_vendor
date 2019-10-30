package com.sv.app.bean;

import java.util.Date;

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
@Table(name = "vending_site_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class VendingSiteBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vending_site_uuid")
	private String vendingSiteId;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "vending_zone_code", nullable = false)
	@JsonIgnore
	private VendingZoneBean vendingZoneBean;

	@Column(name = "vending_site_code")
	private String vendingSiteCode;

	@Column(name = "allotted_from")
	private Date allottedFrom;	
	
	@Column(name = "allotted_upto")
	private Date allottedUpto;

	public String getVendingSiteId() {
		return vendingSiteId;
	}

	public void setVendingSiteId(String vendingSiteId) {
		this.vendingSiteId = vendingSiteId;
	}

	public VendingZoneBean getVendingZoneBean() {
		return vendingZoneBean;
	}

	public void setVendingZoneBean(VendingZoneBean vendingZoneBean) {
		this.vendingZoneBean = vendingZoneBean;
	}

	public String getVendingSiteCode() {
		return vendingSiteCode;
	}

	public void setVendingSiteCode(String vendingSiteCode) {
		this.vendingSiteCode = vendingSiteCode;
	}

	public Date getAllottedFrom() {
		return allottedFrom;
	}

	public void setAllottedFrom(Date allottedFrom) {
		this.allottedFrom = allottedFrom;
	}

	public Date getAllottedUpto() {
		return allottedUpto;
	}

	public void setAllottedUpto(Date allottedUpto) {
		this.allottedUpto = allottedUpto;
	}
}
