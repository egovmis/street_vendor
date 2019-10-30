package com.sv.app.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	
	@Entity
	@Table(name="patients")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class PatientBean implements Serializable{
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="patient_id")
		private long patientId;
		
		
		@Column(name="department")
		private String department;

		@Column(name="status")
		private String status;
		
		@Column(name="lat")
		private String lat;
		
		@Column(name="lon")
		private String lon;
		
		@Column(name="created")
		@CreationTimestamp
		private Timestamp created;
		
		@Column(name="updated")
		@UpdateTimestamp
		private Timestamp updated;
		
	
		@OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
		    @JsonIgnore
		 private UserBean userBean;
		
		


		public PatientBean() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		public PatientBean(long patientId, String department, String status, String lat, String lon, Timestamp created,
				Timestamp updated) {
			super();
			this.patientId = patientId;
			this.department = department;
			this.status = status;
			this.lat = lat;
			this.lon = lon;
			this.created = created;
			this.updated = updated;
		}



		public long getPatientId() {
			return patientId;
		}


		public void setPatientId(long patientId) {
			this.patientId = patientId;
		}


		public String getDepartment() {
			return department;
		}


		public void setDepartment(String department) {
			this.department = department;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public String getLat() {
			return lat;
		}


		public void setLat(String lat) {
			this.lat = lat;
		}


		public String getLon() {
			return lon;
		}


		public void setLon(String lon) {
			this.lon = lon;
		}


		public Timestamp getCreated() {
			return created;
		}


		public void setCreated(Timestamp created) {
			this.created = created;
		}


		public Timestamp getUpdated() {
			return updated;
		}


		public void setUpdated(Timestamp updated) {
			this.updated = updated;
		}


		public UserBean getUserBean() {
			return userBean;
		}


		public void setUserBean(UserBean userBean) {
			this.userBean = userBean;
		}
	 




}
