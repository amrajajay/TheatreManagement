package com.theatreManagement.project.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theatreManagement.project.repository.ReservationRespository;
import com.theatreManagement.project.entity.Reservation;

@Service
public class ReservationService {
	@Autowired
	private ReservationRespository reservationRepository;
	
	public List<Reservation> getAllReservations(){
		return  (List<Reservation>) reservationRepository.findAll();
	}
	
	
	public Reservation getTicketData(String id) {
		return  (Reservation) getAllReservations().stream().filter(i->i.getTicketId().equals(id));
	}
	public Reservation bookTicket(int mid,int seats,Date date,String slot) {
		Reservation ticket=new Reservation();
		ticket.setDate(date);
		ticket.setMovieId(mid);
		ticket.setSeats(seats);
		ticket.setSeatNumbers("A1,B1");
		ticket.setTimeSlot(slot);
		return reservationRepository.save(ticket);
		
		
	}
	public Reservation getReservationById(String ticketId){
		return reservationRepository.findById(ticketId).orElse(null);
		
	}
	public void deleteReservation(String ticketId) {
		reservationRepository.deleteById(ticketId);
	}

}
