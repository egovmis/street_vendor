package com.sv.app.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "designations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DesignationBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "designation_code")
	private String designationCode;

	@Column(name = "designation_name")
	private String designationName;

	/*
	 * @OneToMany(mappedBy = "designationBean", cascade = CascadeType.ALL,
	 * orphanRemoval = true) private List<EmployeeBean> employeeBean = new
	 * ArrayList<EmployeeBean>();
	 */

	// ============Setter and Getter=============//

	public String getDesignationCode() {
		return designationCode;
	}

	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/*
	 * public List<EmployeeBean> getEmployeeBean() { return employeeBean; }
	 * 
	 * public void setEmployeeBean(List<EmployeeBean> employeeBean) {
	 * this.employeeBean = employeeBean; }
	 */

}
