package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Admin;
import com.example.demo.repo.AdminRepo;

@CrossOrigin(origins ="null", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private AdminRepo adminRepo;
	
	 @PostMapping("/adminRepo")
	    public Admin createUser(@RequestBody Admin reg) {
	        return adminRepo.save(reg);
	    }
	 @GetMapping("/adminlogin")
	    public List < Admin > checkUser() {
	        return adminRepo.findAll();
	    }


}
