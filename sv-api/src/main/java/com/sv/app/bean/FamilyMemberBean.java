package com.sv.app.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
