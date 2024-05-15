package com.example.demo.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class cartitem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartitemid;
	private String productId;
	
	private String price;
	
	private int productName;

	public cartitem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public cartitem(int cartitemid, String productId, String price, int productName) {
		super();
		this.cartitemid = cartitemid;
		this.productId = productId;
		this.price = price;
		this.productName = productName;
	}

	public int getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getProductName() {
		return productName;
	}

	public void setProductName(int productName) {
		this.productName = productName;
	}

	

	
	
	
}
