package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.User;
import com.example.demo.repo.UserRepo;

@CrossOrigin(origins ="null", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepo userrepo;
	
	 @PostMapping("/userrepo")
	    public User createUser(@RequestBody User reg) {
	        return userrepo.save(reg);
	    }
	 @GetMapping("/login")
	    public List < User > checkUser() {
	        return userrepo.findAll();
	    }
	

}
