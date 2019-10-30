package com.sv.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="application_status")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ApplicationStatusBean {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="status_code")
		private String statusCode;

		@Column(name="status_description")
		private String statusDescription;

		public String getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(String statusCode) {
			this.statusCode = statusCode;
		}

		public String getStatusDescription() {
			return statusDescription;
		}

		public void setStatusDescription(String statusDescription) {
			this.statusDescription = statusDescription;
		}
		
		
}
