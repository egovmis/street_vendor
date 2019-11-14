package com.sv.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name="reg_vendor")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class MonthlyPaymentsBean {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id")
		private long id;
	
		@Column(name="reg_uuid")
		private String regUuid;
		
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="allocation_uuid")
		@JsonIgnore
		private ZoneAllocationBean allocationUUID;

		@Column(name="month")
		private String month;
		
		@Column(name="year")
		private String year;
		
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="trans_id")
		@JsonIgnore
		private TransactionBean transactionId;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getRegUuid() {
			return regUuid;
		}

		public void setRegUuid(String regUuid) {
			this.regUuid = regUuid;
		}

		public ZoneAllocationBean getAllocationUUID() {
			return allocationUUID;
		}

		public void setAllocationUUID(ZoneAllocationBean allocationUUID) {
			this.allocationUUID = allocationUUID;
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public TransactionBean getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(TransactionBean transactionId) {
			this.transactionId = transactionId;
		}

		public String getAmountReceived() {
			return amountReceived;
		}

		public void setAmountReceived(String amountReceived) {
			this.amountReceived = amountReceived;
		}

		@Column(name="amount_received")
		private String amountReceived;

		
		
		
	}
