package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Coupon;
import com.example.demo.repo.CouponRepo;


@Service
@Transactional
public class CouponService {
	final CouponRepo couponRepo;
	
	@Autowired
	public CouponService(CouponRepo couponRepo) {
		this.couponRepo = couponRepo;

	}
	public List<Coupon> getAllCoupon() {
		List<Coupon> coupons = new ArrayList<Coupon>();
		couponRepo.findAll().forEach(coupon1 -> {
			coupons.add(coupon1);
		});
		return coupons;
	}
	public void saveOrUpdate(Coupon coupons) {
		couponRepo.save(coupons);
	}
	public void delete(int coupon_id) {
		couponRepo.deleteById(coupon_id);
	}

	

}
