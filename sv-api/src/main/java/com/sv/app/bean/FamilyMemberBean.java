package com.sv.app.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="family_members_master")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FamilyMemberBean {
	
		@Id
		@Column(name="family_member_uuid")
		private String familyMemberUuid;

		
	/*
	 * @ManyToAny(fetch = FetchType.LAZY, metaColumn
	 * = @Column(name="vendor_reg_id"))
	 * 
	 * @JoinColumn(name = "reg_uuid", nullable = false)
	 * 
	 * @JsonIgnore private VendorBean vendorRegID ;
	 */

		@Column(name="name")
		private String name;

		@Column(name="gender")
		private String gender;

		@Column(name="relation")
		private String relation;

		@Column(name="dob")
		private Date dateOfBirth;

		
		
		
}
