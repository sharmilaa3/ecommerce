package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.cartitem;
import com.example.demo.service.cartitemService;


@CrossOrigin(origins ="null", allowedHeaders = "*")
@RestController
@RequestMapping("/crt")
public class cartitemController {
	
	@Autowired
	cartitemService cartitemservice;

	@GetMapping("/carts")
	private List<cartitem> getAllcartitem() {
		return cartitemservice.getAllcartitems();
	}
	
	@PostMapping("/cart_save")
	private cartitem savecartitem(@RequestBody cartitem cartitem1) {
		cartitemservice.saveOrUpdate(cartitem1);
		return cartitem1;
	}
	

	@GetMapping("/cart/{cartitemid}")
	private cartitem getcartitem(@PathVariable("product_id") int cartitemId) {
		return cartitemservice.getcartitemById(cartitemId);
	}
	
	
	
	
	@DeleteMapping("/product/{product_id}")
	private void deleteProducts(@PathVariable("product_id") int cartitemId) {
		cartitemservice.delete(cartitemId);
	}
	
	

	
}
