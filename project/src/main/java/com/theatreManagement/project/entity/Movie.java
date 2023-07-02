package com.theatreManagement.project.entity;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "time")
	private String time;
	@Column(name = "avaliable_from")
	private Date fromDate;
	@Column(name = "avaliable_to")
	private Date toDate;
	@Column(name = "time_slots")
	private String timeSlots;
	
	public String getTimeSlots() {
		return timeSlots;
	}
	public void setTimeSlots(String timeSlots) {
		this.timeSlots = timeSlots;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Movie() {
		super();
	}
	public Movie(int id, String name, String time, Date fromDate, Date toDate) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", fromDate=" + fromDate + ", toDate=" + toDate + ", timeSlots=" + timeSlots
				+ "]";
	}
	
	
	
}
