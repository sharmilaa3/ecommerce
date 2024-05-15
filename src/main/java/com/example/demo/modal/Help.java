package com.example.demo.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="help")
public class Help {
	
	
	@Column(name ="name")
	private String name;
    @Id
	@Column(name ="email")
	private String email;

	@Column(name ="phonenumber")
	private long phonenumber;
	
	@Column(name ="description")
	private String description;

	public Help() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Help(String name, String email, long phonenumber, String description) {
		super();
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.description = description;
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

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
