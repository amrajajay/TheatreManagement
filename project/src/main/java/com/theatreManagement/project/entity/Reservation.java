package com.theatreManagement.project.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	

	
	@Column(name = "movie_id")
	private int movieId;
	
	@Column(name = "seats")
	private int seats;
	
	@Column(name = "seat_numbers")
	private String seatNumbers;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(columnDefinition = "ticket_id")
	private String ticketId;
	@Column(name = "booking_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@Column(name = "slot")
	private String timeSlot;
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}	
	

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String time_slot) {
		this.timeSlot = time_slot;
	}

	public Reservation() {
		super();
	}

	

	public Reservation(int movieId, int seats, String seatNumbers, String ticketId, Date date, String time_slot) {
		super();
		this.movieId = movieId;
		this.seats = seats;
		this.seatNumbers = seatNumbers;
		this.ticketId = ticketId;
		this.date = date;
		this.timeSlot = time_slot;
	}

	@Override
	public String toString() {
		return "\nseats: " + seats + "\nseatNumbers: " + seatNumbers + "\nticketId: "
				+ ticketId + "\ndate: " + date +"\nTime: "+timeSlot;
	}

	

}
