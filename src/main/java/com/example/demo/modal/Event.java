package com.example.demo.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="event")
public class Event {

	public Event() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventid")
    private int eventid;
	
	@Column(name = "eventname")
    private String eventname;
    @Column(name = "eventstartdate")
    private String eventstartdate;
    @Column(name = "eventenddate")
    private String eventenddate;
    
	public Event(int eventid, String eventname, String eventstartdate, String eventenddate) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
		this.eventstartdate = eventstartdate;
		this.eventenddate = eventenddate;
	}
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getEventstartdate() {
		return eventstartdate;
	}
	public void setEventstartdate(String eventstartdate) {
		this.eventstartdate = eventstartdate;
	}
	public String getEventenddate() {
		return eventenddate;
	}
	public void setEventenddate(String eventenddate) {
		this.eventenddate = eventenddate;
	}
	
	
     
	
}
	
   