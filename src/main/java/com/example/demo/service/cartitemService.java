package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.modal.cartitem;
import com.example.demo.repo. cartitemRepo;


@Service
@Transactional
public class cartitemService {
	final  cartitemRepo cartitemrepo;
	
	@Autowired
	public cartitemService( cartitemRepo  cartitemrepo) {
		this.cartitemrepo = cartitemrepo;

	}
	public List<cartitem> getAllcartitems() {
		List<cartitem> cartitems = new ArrayList<cartitem>();
		cartitemrepo.findAll().forEach(cartitem1 -> {
			 cartitems.add(cartitem1);
		});
		return  cartitems;
	}
	public void saveOrUpdate(cartitem  cartitems) {
		cartitemrepo.save(cartitems);
	}
	public void delete(int cartItemId) {
		cartitemrepo.deleteById(cartItemId);
	}
	public cartitem getcartitemById(int cartitemId) {
		return cartitemrepo.findById(cartitemId).get();
	}

	

}
