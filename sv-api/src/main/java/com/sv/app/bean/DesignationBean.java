package com.sv.app.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name="designation")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class DesignationBean implements Serializable{
		
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name="designation_code")
		private long designationCode;
		
		@Column(name="designation_name")
		private long designationName;

		public long getDesignationCode() {
			return designationCode;
		}

		public void setDesignationCode(long designationCode) {
			this.designationCode = designationCode;
		}

		public long getDesignationName() {
			return designationName;
		}

		public void setDesignationName(long designationName) {
			this.designationName = designationName;
		}
		
		
}
