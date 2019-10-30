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
@Table(name="staff")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StaffBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="staff_id")
	private long staffId;
	
	
	@Column(name="staff_type")
	private String staffType;

	@Column(name="created")
	@CreationTimestamp
	private Timestamp created;
	
	@Column(name="updated")
	@UpdateTimestamp
	private Timestamp updated;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	    @JsonIgnore
	 private UserBean userBean;


public long getStaffId() {
	return staffId;
}


public void setStaffId(long staffId) {
	this.staffId = staffId;
}


public String getStaffType() {
	return staffType;
}


public void setStaffType(String staffType) {
	this.staffType = staffType;
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