package com.sv.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	
	@Entity
	@Table(name="vending_type_master")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class VendingTypeBean{
		
		@Id
		@Column(name="business_type_uuid")
		private String businessTypeUuid;
		
		
		@Column(name="business_type_name")
		private String businessTypeName;


		public String getBusinessTypeUuid() {
			return businessTypeUuid;
		}


		public void setBusinessTypeUuid(String businessTypeUuid) {
			this.businessTypeUuid = businessTypeUuid;
		}


		public String getBusinessTypeName() {
			return businessTypeName;
		}


		public void setBusinessTypeName(String businessTypeName) {
			this.businessTypeName = businessTypeName;
		}


}
