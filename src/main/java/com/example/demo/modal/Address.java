package com.example.demo.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
    
	@Column(name ="name")
	private String name;

	@Column(name ="email")
	private String email;

	@Column(name ="city")
	private String city;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="zipcode")
	private int zipcode;
	
	@Column(name ="state")
	private String state;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
}

	public Address(int userid, String name, String email, String city, String address, int zipcode, String state) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.city = city;
		this.address = address;
		this.zipcode = zipcode;
		this.state = state;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}
	
}