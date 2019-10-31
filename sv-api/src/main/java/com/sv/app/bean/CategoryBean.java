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
	public class CategoryBean {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="category_name")
		private long categoryName;

		public long getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(long categoryName) {
			this.categoryName = categoryName;
		}
			   
}
