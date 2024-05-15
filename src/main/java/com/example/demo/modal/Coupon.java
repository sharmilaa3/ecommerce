package com.example.demo.modal;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="coupon")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coupon_id;
	@Column(name = "coupon_name")
    private String coupon_name;
    @Column(name = "coupon_code")
    private String coupon_code;
    @Column(name = "discount_price")
    private int discount_price;
    @Column(name = "expiry_date")
    private String expiry_date;
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coupon(int coupon_id, String coupon_name, String coupon_code, int discount_price, String expiry_date) {
		super();
		this.coupon_id = coupon_id;
		this.coupon_name = coupon_name;
		this.coupon_code = coupon_code;
		this.discount_price = discount_price;
		this.expiry_date = expiry_date;
	}
	public int getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public String getCoupon_code() {
		return coupon_code;
	}
	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}
	public int getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(int discount_price) {
		this.discount_price = discount_price;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
  
    
}
