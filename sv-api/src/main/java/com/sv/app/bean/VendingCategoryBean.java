package com.sv.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	@Entity
	@Table(name="vending_category_master")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class VendingCategoryBean {
		
		@Id
		@Column(name="category_name")
		private String categoryName;

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
			   
}
