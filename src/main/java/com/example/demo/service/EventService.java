

package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.modal.Event;

import com.example.demo.repo.EventRepo;


@Service
@Transactional
public class EventService {
	final EventRepo eventrepo;
	
	@Autowired
	public EventService(EventRepo eventrepo) {
		this.eventrepo = eventrepo;

	}
	public List<Event> getAllEvent() {
		List<Event> events = new ArrayList<Event>();
		eventrepo.findAll().forEach(event1 -> {
			events.add(event1);
		});
		return events;
	}
	public void saveOrUpdate(Event events) {
		eventrepo.save(events);
	}
//	public void delete(String eventname) {
//		eventrepo.deleteById(eventname);
//	}

	

}
