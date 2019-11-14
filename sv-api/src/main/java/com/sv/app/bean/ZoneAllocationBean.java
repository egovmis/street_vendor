package com.sv.app.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name="zone_allocation")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class ZoneAllocationBean {

		@Id
		@Column(name="allocation_uuid")
		private String allocationUUID;
	
	
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "reg_uuid", nullable = false)
		@JsonIgnore
		private VendorBean vendorRegId;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "vending_site_code", nullable = false)
		@JsonIgnore
		private VendingSiteBean vendingSite;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "zone_code", nullable = false)
		@JsonIgnore
		private VendingZoneBean zoneCode;
		
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "allocated_by_employee", nullable = false)
		@JsonIgnore
		private EmployeeBean allocatedByEmployee;
		
		@Column(name="active")
		private String active;
		
		@Column(name="monthly_rent_applied")
		private String rentApplied;
		

		@Column(name="allocated_to_date")
		private Date allocatedToDate;
		

		@Column(name="payment_made_upto_date")
		private Date paymentUptoDate;
		

		@Column(name="datetime_aproval")
		private Date datetimeApproval;
				
		
	}
