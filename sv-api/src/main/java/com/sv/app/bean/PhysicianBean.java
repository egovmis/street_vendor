package com.sv.app.bean;

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
	@Table(name="physician")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class PhysicianBean {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="physician_id")
		private long physicianId;
		
		
		@Column(name="roll")
		private String roll;

		@Column(name="status")
		private String status;
			
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


	public long getPhysicianId() {
		return physicianId;
	}


	public void setPhysicianId(long physicianId) {
		this.physicianId = physicianId;
	}


	public String getRoll() {
		return roll;
	}


	public void setRoll(String roll) {
		this.roll = roll;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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
