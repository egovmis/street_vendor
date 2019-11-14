package com.sv.app.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "market_type_master")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	public class MktTypeMasterBean implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "mkt_id")
		private int mktId;

		@Column(name = "mkt_name")
		private String mktName;

		public int getMktId() {
			return mktId;
		}

		public void setMktId(int mktId) {
			this.mktId = mktId;
		}

		public String getMktName() {
			return mktName;
		}

		public void setMktName(String mktName) {
			this.mktName = mktName;
		}

		
}
