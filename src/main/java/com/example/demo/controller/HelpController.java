package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modal.Help;
import com.example.demo.repo.HelpRepo;


@CrossOrigin(origins ="null", allowedHeaders = "*")
@RestController
@RequestMapping("/hp")
public class HelpController {

	
	@Autowired
	private HelpRepo helpRepo;
	
	 @PostMapping("/help")
	    public Help createHelp(@RequestBody Help help) {
	        return helpRepo.save(help);
	    }
}
