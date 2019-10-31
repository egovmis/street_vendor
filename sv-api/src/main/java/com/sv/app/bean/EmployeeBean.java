package com.sv.app.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name="patients")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class EmployeeBean implements Serializable{
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="emp_id")
		private long empId;
		
		
		@Column(name="name")
		private String name;
		
		@Column(name="phone_no")
		private String phoneNo;
		
		@Column(name="designation")
		private String designation;
		
		@Column(name="ulb_code")
		private String ulbCode;
		
		@Column(name="password")
		private String password;
		
		@Column(name="active")
		private String active;
		
		   @ManyToOne(optional=false)
		    @JoinColumn(name="designation",referencedColumnName="designation_code", insertable=false, updatable=false)
		    @JsonIgnore
		private DesignationBean designationBean;
		 
	/*
	 * @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
	 * "employeeBean") private DesignationBean designationBean;
	 */

}
