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

import com.example.demo.modal.Coupon;
import com.example.demo.service.CouponService;

@CrossOrigin(origins ="null", allowedHeaders = "*")
@RestController
@RequestMapping("/cpn")
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	
	 @PostMapping("/couponrepo")
	    public Coupon createCoupon(@RequestBody Coupon coupons) {
		 couponService.saveOrUpdate(coupons);
		 return coupons;
	    }
	 @GetMapping("/coupList")
	    public List < Coupon > getAllCoupon() {
	        return couponService.getAllCoupon();
	    }
	 @DeleteMapping("/coupon/{coupon_id}")
		private void deleteCoupon(@PathVariable("coupon_id") int coupon_id) {
		 couponService.delete(coupon_id);
		}
	 
}
