package com.example.demo.modal;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "ordertable")
@Getter
@Setter
public class Ordertable {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int orderId;
		
		private int product_id;
		
		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name = "product_id", insertable = false, updatable = false)
		private Products productDetails;
		
		private int userid;
		
		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name = "userid", insertable = false, updatable = false)
		private User userDetails;
		
		private int quantity;
		
		private double totalAmount;

		public Ordertable() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Ordertable(int orderId, int product_id, Products productDetails, int userid, User userDetails,
				int quantity, double totalAmount) {
			super();
			this.orderId = orderId;
			this.product_id = product_id;
			this.productDetails = productDetails;
			this.userid = userid;
			this.userDetails = userDetails;
			this.quantity = quantity;
			this.totalAmount = totalAmount;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public int getProduct_id() {
			return product_id;
		}

		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}

		public Products getProductDetails() {
			return productDetails;
		}

		public void setProductDetails(Products productDetails) {
			this.productDetails = productDetails;
		}

		public int getUserid() {
			return userid;
		}

		public void setUserid(int userid) {
			this.userid = userid;
		}

		public User getUserDetails() {
			return userDetails;
		}

		public void setUserDetails(User userDetails) {
			this.userDetails = userDetails;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
		
		
		
}
