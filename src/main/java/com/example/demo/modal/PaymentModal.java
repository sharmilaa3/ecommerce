package com.example.demo.modal;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment1")
public class PaymentModal {

	
	@Column(name = "fullname")
    private String fullname;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name ="city")
    private String city;
    @Column(name = "state")
    private String state;
    @Id
    @Column(name="zip")
    private int zip;
	public PaymentModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentModal(String fullname, String email, String address,String city,String state, int zip) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
}
