
package com.example.demo.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modal.Event;

import com.example.demo.service.EventService;

@CrossOrigin(origins ="null", allowedHeaders = "*")
@RestController
@RequestMapping("/evt")
public class EventController {
	
	@Autowired
	private EventService eventservice;
	
	
	 @PostMapping("/eventrepo")
	    public Event createEvent(@RequestBody Event events) {
		 eventservice.saveOrUpdate(events);
		 return events;
	    }
	 @GetMapping("/eventList")
	    public List < Event > getAllEvent() {
	        return eventservice.getAllEvent();
	    }
//	 @DeleteMapping("/e/{coupon_id}")
//		private void deleteCoupon(@PathVariable("coupon_id") int coupon_id) {
//		 couponService.delete(coupon_id);
//		}
	 
}

