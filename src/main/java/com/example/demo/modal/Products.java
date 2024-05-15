             package com.example.demo.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


//import com.example.demo.modal.ProductsCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
@Table(name="products")
public class Products {
	
	
	@Lob
	@Column(name ="product_image")
	private String product_image;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;

	@Column(name ="product_name")
	private String product_name;

	@Column(name ="product_type")
	private String product_type;

	@Column(name ="product_price")
	private int product_price;
	
	@Column(name ="product_descr")
	private String product_descr;
	
	

	public String getProduct_image() {
		return product_image;
	}



	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}



	public int getProduct_id() {
		return product_id;
	}



	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getProduct_type() {
		return product_type;
	}



	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}



	public int getProduct_price() {
		return product_price;
	}



	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}



	public String getProduct_descr() {
		return product_descr;
	}



	public void setProduct_descr(String product_descr) {
		this.product_descr = product_descr;
	}



	public List<cartitem> getAddedCarts() {
		return addedCarts;
	}



	public void setAddedCarts(List<cartitem> addedCarts) {
		this.addedCarts = addedCarts;
	}



	public Products(String product_image, int product_id, String product_name, String product_type, int product_price,
			String product_descr, List<cartitem> addedCarts) {
		super();
		this.product_image = product_image;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_type = product_type;
		this.product_price = product_price;
		this.product_descr = product_descr;
		this.addedCarts = addedCarts;
	}



	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "cart_products", 
			joinColumns = @JoinColumn(name = "product_id"), 
	inverseJoinColumns = @JoinColumn(name = "cartitemid"))
	private List<cartitem> addedCarts = new ArrayList<>();
	
	public void addProducts(cartitem cart) {
		addedCarts.add(cart);
	}

	public void removeProducts(cartitem  cart) {
		addedCarts.remove(cart);
	}
	
	
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}


	

}