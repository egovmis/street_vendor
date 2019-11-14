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
	@Table(name="transactions")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class TransactionBean {

		@Id
		@Column(name="trans_id")
		private String transactionId;

		public String getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}

		public VendorBean getRegistrationId() {
			return registrationId;
		}

		public void setRegistrationId(VendorBean registrationId) {
			this.registrationId = registrationId;
		}

		public String getTransactionUUID() {
			return transactionUUID;
		}

		public void setTransactionUUID(String transactionUUID) {
			this.transactionUUID = transactionUUID;
		}

		public String getUniqueApplicationNumber() {
			return uniqueApplicationNumber;
		}

		public void setUniqueApplicationNumber(String uniqueApplicationNumber) {
			this.uniqueApplicationNumber = uniqueApplicationNumber;
		}

		public Date getDateTimeTransaction() {
			return dateTimeTransaction;
		}

		public void setDateTimeTransaction(Date dateTimeTransaction) {
			this.dateTimeTransaction = dateTimeTransaction;
		}

		public String getAmountPaid() {
			return amountPaid;
		}

		public void setAmountPaid(String amountPaid) {
			this.amountPaid = amountPaid;
		}

		public String getTransactionStatus() {
			return transactionStatus;
		}

		public void setTransactionStatus(String transactionStatus) {
			this.transactionStatus = transactionStatus;
		}

		public String getPaidForReason() {
			return paidForReason;
		}

		public void setPaidForReason(String paidForReason) {
			this.paidForReason = paidForReason;
		}

		public String getPgFields() {
			return pgFields;
		}

		public void setPgFields(String pgFields) {
			this.pgFields = pgFields;
		}

		public String getAdditionalDetails() {
			return additionalDetails;
		}

		public void setAdditionalDetails(String additionalDetails) {
			this.additionalDetails = additionalDetails;
		}

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "reg_uuid", nullable = false)
		@JsonIgnore
		private VendorBean registrationId;
		
		@Column(name="trans_uuid")
		private String transactionUUID;
		
		@Column(name="unique_application_number")
		private String uniqueApplicationNumber;
		

		@Column(name="date_time_trans")
		private Date dateTimeTransaction;
		

		@Column(name="amount_paid")
		private String amountPaid;
		
		@Column(name="trans_status")
		private String transactionStatus;
		
		@Column(name="paid_for_reason")
		private String paidForReason;
		
		@Column(name="pg_fields")
		private String pgFields;
		
		@Column(name="additional_details")
		private String additionalDetails;
		
				
		
	}
