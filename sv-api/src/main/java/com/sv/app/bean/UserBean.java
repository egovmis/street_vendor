package com.sv.app.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name="user_name")
	private String userName;
	
	@NotEmpty
	@NotNull
	  @Size(min=2, message="Name should have atleast 2 characters")
	@NotBlank(message = "Email is mandatory")
	@Column(unique=true)
	private String Email;
	
	@NotEmpty
	@NotBlank(message = "Password is mandatory")
	@Column(name="password")
	private String password;
	
	@Column(name="profile_image")
	private String profileImage;
	
	@Column(name="auth_token")
	private String authToken;
	
	@Column(name="created")
	@CreationTimestamp
	private Timestamp created;
	
	@Column(name="updated")
	@UpdateTimestamp
	private Timestamp updated;

	
	 @OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "userBean")
	 private PatientBean patientBean;	
	 
		
	 @OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "userBean")
	 private CompanyBean companyBean;	
//	 
	 @OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "userBean")
	private PhysicianBean physicianBean;

	 @OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "userBean")
	private StaffBean staffBean;
	 

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public UserBean(long id, String firstName, String lastName, String phoneNo, String userName, String email,
			String password, String profileImage, String authToken, Timestamp created, Timestamp updated) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.userName = userName;
		Email = email;
		this.password = password;
		this.profileImage = profileImage;
		this.authToken = authToken;
		this.created = created;
		this.updated = updated;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public String getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
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


	public PatientBean getPatientBean() {
		return patientBean;
	}


	public void setPatientBean(PatientBean patientBean) {
		this.patientBean = patientBean;
	}



	
	  public StaffBean getStaffBean() { return staffBean; }
	  
	  
	  
	  public void setStaffBean(StaffBean staffBean) { this.staffBean = staffBean; }
	  
	 
	  
	  public PhysicianBean getPhysicianBean() { return physicianBean; }
	  
	  
	  
	  public void setPhysicianBean(PhysicianBean physicianBean) {
	  this.physicianBean = physicianBean; }
	 


	
	  public CompanyBean getCompanyBean() { return companyBean; }
	  
	  
	  
	  public void setCompanyBean(CompanyBean companyBean) { this.companyBean =
	  companyBean; }
	 
	


}