package com.sv.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	
	@Entity
	@Table(name="business_type_master")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class BussinessTypeBean{
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="business_type_uuid")
		private long businessTypeUuid;
		
		
		@Column(name="business_type_name")
		private String businessTypeName;


		public long getBusinessTypeUuid() {
			return businessTypeUuid;
		}


		public void setBusinessTypeUuid(long businessTypeUuid) {
			this.businessTypeUuid = businessTypeUuid;
		}


		public String getBusinessTypeName() {
			return businessTypeName;
		}


		public void setBusinessTypeName(String businessTypeName) {
			this.businessTypeName = businessTypeName;
		}


}
