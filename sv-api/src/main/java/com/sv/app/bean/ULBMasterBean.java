package com.sv.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ulb_master")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ULBMasterBean {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="ulb_code")
		private String ulbCode;

		@Column(name="ulb_name")
		private String ulbName;
		
		public String getUlbName() {
			return ulbName;
		}

		public void setUlb_name(String ulbName) {
			this.ulbName = ulbName;
		}

		public String getDistrict() {
			return district;
		}

		public void setDistrict(String district) {
			this.district = district;
		}

		public String getUlbCode() {
			return ulbCode;
		}

		public void setCityCode(String ulbCode) {
			this.ulbCode = ulbCode;
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

		public String getNo_of_eo() {
			return no_of_eo;
		}

		public void setNo_of_eo(String no_of_eo) {
			this.no_of_eo = no_of_eo;
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

		public String getAmrut_town() {
			return amrut_town;
		}

		public void setAmrut_town(String amrut_town) {
			this.amrut_town = amrut_town;
		}

		@Column(name="district")
		private String district;
		
		@Column(name="type")
		private String type;
		
		@Column(name="DDR")
		private String DDR;
		
		@Column(name="no_of_eo")
		private String no_of_eo;
		
		@Column(name="contact_no")
		private String contact_no;
		
		@Column(name="password")
		private String password;
		
		@Column(name="amrut_town")
		private String amrut_town;
		
			

}
