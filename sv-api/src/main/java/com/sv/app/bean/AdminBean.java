package com.sv.app.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="adminstrator")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdminBean {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id")
		private long userId;

		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Column(name="phone_no")
		private String phoneNo;
		
		@Column(name="user_name")
		private String userName;
		
		@Column(name="email")
		private String Email;
		
		@Column(name="password")
		private String password;
		
		@Column(name="site_name")
		private String siteName;
		
		@Column(name="url_name")
		private String urlName;
		
		@Column(name="support_email")
		private String supportEmail;
		
		@Column(name="auth_token")
		private String authToken;
		
		@Column(name="created")
		@CreationTimestamp
		private Timestamp created;
		
		@Column(name="updated")
		@UpdateTimestamp
		private Timestamp updated;

		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getSiteName() {
			return siteName;
		}

		public void setSiteName(String siteName) {
			this.siteName = siteName;
		}

		public String getUrlName() {
			return urlName;
		}

		public void setUrlName(String urlName) {
			this.urlName = urlName;
		}

		public String getSupportEmail() {
			return supportEmail;
		}

		public void setSupportEmail(String supportEmail) {
			this.supportEmail = supportEmail;
		}

		public String getAuthToken() {
			return authToken;
		}

		public void setAuthToken(String authToken) {
			this.authToken = authToken;
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
		
		

}
