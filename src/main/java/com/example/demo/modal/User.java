package com.example.demo.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user1")
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "userid")
	    private int userid;
	    @Column(name = "username")
	    private String username;
	    @Column(name = "email")
	    private String email;
	    @Column(name = "password")
	    private String password;
	    @Column(name = "retypepassword")
	    private String retypepassword;
	   
	    
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}


		public int getUserid() {
			return userid;
		}


		public void setUserid(int userid) {
			this.userid = userid;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getRetypepassword() {
			return retypepassword;
		}


		public void setRetypepassword(String retypepassword) {
			this.retypepassword = retypepassword;
		}
		
	   
	     
	    
	    
	
}		
	    
	
