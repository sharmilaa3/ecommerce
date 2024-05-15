package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.PaymentModal;
import com.example.demo.repo.PaymentMoRepo;

@CrossOrigin(origins ="null", allowedHeaders = "*")
@RestController
@RequestMapping("/pmtt")
public class PaymentMoController {
	
	@Autowired
	private PaymentMoRepo paymentMoRepo;
	
	 @PostMapping("/paymen")
	    public PaymentModal createPaymentM(@RequestBody PaymentModal payment) {
		 return paymentMoRepo.save(payment);
	    }

}
