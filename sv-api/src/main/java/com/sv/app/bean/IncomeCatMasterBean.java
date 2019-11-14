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
@Table(name = "income_category_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class IncomeCatMasterBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "income_cat_id")
	private int incomeCatId;

	@Column(name = "income_cat_name")
	private String incomeCatName;

	public int getIncomeCatId() {
		return incomeCatId;
	}

	public void setIncomeCatId(int incomeCatId) {
		this.incomeCatId = incomeCatId;
	}

	public String getIncomeCatName() {
		return incomeCatName;
	}

	public void setIncomeCatName(String incomeCatName) {
		this.incomeCatName = incomeCatName;
	}

}
