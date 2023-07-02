package com.theatreManagement.project.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie_show")
public class ShowSeats {

	@Id
	@Column(name = "date")
	private Date date;
	@Column(name = "morning")
	private int morningShow;
	@Column(name = "matinee")
	private int matineeShow;
	@Column(name = "first")
	private int firstShow;
	@Column(name = "second")
	private int secondShow;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMorningShow() {
		return morningShow;
	}
	public void setMorningShow(int morningShow) {
		this.morningShow = morningShow;
	}
	public int getMatineeShow() {
		return matineeShow;
	}
	public void setMatineeShow(int matineeShow) {
		this.matineeShow = matineeShow;
	}
	public int getFirstShow() {
		return firstShow;
	}
	public void setFirstShow(int firstShow) {
		this.firstShow = firstShow;
	}
	public int getSecondShow() {
		return secondShow;
	}
	public void setSecondShow(int secondShow) {
		this.secondShow = secondShow;
	}
	public ShowSeats(Date date, int morningShow, int matineeShow, int firstShow, int secondShow) {
		super();
		this.date = date;
		this.morningShow = morningShow;
		this.matineeShow = matineeShow;
		this.firstShow = firstShow;
		this.secondShow = secondShow;
	}
	
	public ShowSeats() {
		super();
	}
	
	
	
	
	
}
