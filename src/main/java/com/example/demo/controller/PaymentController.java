package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modal.Payment;
import com.example.demo.repo.PaymentRepo;


@CrossOrigin(origins ="null", allowedHeaders = "*")
@RestController
@RequestMapping("/pmt")
public class PaymentController {
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	 @PostMapping("/payment")
	    public Payment createPayment(@RequestBody Payment payments) {
		 return paymentRepo.save(payments);
	    }

}
