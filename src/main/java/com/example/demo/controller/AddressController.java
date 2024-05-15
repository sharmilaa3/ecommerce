package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Address;
import com.example.demo.repo.AddressRepo;

@CrossOrigin(origins ="null", allowedHeaders = "*")
@RestController
@RequestMapping("/ad")
public class AddressController {

	@Autowired
	private AddressRepo addressrepo;
	
	 @PostMapping("/address")
	    public Address createAddress(@RequestBody Address address) {
	        return addressrepo.save(address);
	    }
}
