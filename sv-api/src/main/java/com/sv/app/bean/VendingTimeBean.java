package com.sv.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	
	@Entity
	@Table(name="vending_time_master")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class VendingTimeBean{
		
		@Id
		@Column(name="vending_time_id")
		private int vendingTimeId;
		
		
		@Column(name="vending_time")
		private String vendingTime;


		public int getVendingTimeId() {
			return vendingTimeId;
		}


		public void setVendingTimeId(int vendingTimeId) {
			this.vendingTimeId = vendingTimeId;
		}


		public String getVendingTime() {
			return vendingTime;
		}


		public void setVendingTime(String vendingTime) {
			this.vendingTime = vendingTime;
		}


		

}
