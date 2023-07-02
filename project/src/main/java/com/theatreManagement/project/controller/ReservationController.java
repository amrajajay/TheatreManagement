package com.theatreManagement.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.theatreManagement.project.entity.Movie;
import com.theatreManagement.project.entity.Reservation;
import com.theatreManagement.project.entity.ShowSeats;
import com.theatreManagement.project.service.MovieService;
import com.theatreManagement.project.service.ReservationService;
import com.theatreManagement.project.service.ShowSeatsService;

@RestController
@RequestMapping("/v1/myTheatre")
public class ReservationController {
	@Autowired
	private ReservationService reservation;
	@Autowired
	private MovieService movie;
	@Autowired
	private ShowSeatsService show;
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	
	@GetMapping("/getTicketData")
	public String getTicketDeatils(
			@RequestParam(value ="ticket_id",required=true)
			String ticketId) {
		
		Reservation res= reservation.getTicketData(ticketId);
		if(res == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Ticket Not Found");
		return res.toString();
	}
	
	@GetMapping("/getMovies")
	public List<Movie> getMovieDetails() {
		return  movie.getMovies();
	}
	@PostMapping("/bookTicket")
	public String bookTickets(
			@RequestParam(value ="movie_name",required=true)
			String movieName,
			@RequestParam(value ="movie_time",required=true)
			String movieTime,
			@RequestParam(value ="no_of_seats",required=true)
			int NoOfSeats,
			@RequestParam(value ="date",required=true)
			String inputdate
			) {
		
		try {
			Date date = formatter.parse(inputdate);
			 movie.checkMovieAvaliable(movieName,date,movieTime,NoOfSeats);
			 ShowSeats showslotseats=show.getShowSeatsByDate(date);
			 Movie m=movie.getMovieDetaisByMovieName(movieName);
			 Reservation book = reservation.bookTicket(m.getId(),NoOfSeats,date,movieTime);
			 show.saveWithShow(showslotseats,movieTime,NoOfSeats);
			 return "\nMovie :"+movieName+movieTime+book;
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	@GetMapping("/getTicket")
	public String getTicketData(
			@RequestParam(value ="ticket_id",required=true)
			String ticketId) {
		
		Reservation ticketData=reservation.getReservationById(ticketId);
		if(ticketData == null) {
			return "TicketID not found";
		}
		Movie m=movie.findByMovieId(ticketData.getMovieId());
		return "\nMovie :"+m.getName()+ticketData;
	}
	@DeleteMapping("/CancelTicket")
	public String cancelTicket(
			@RequestParam(value ="ticket_id",required=true)
			String ticketId) {
		
		Reservation ticketData=reservation.getReservationById(ticketId);
		if(ticketData == null) {
			return "TicketID not found";
		}
		ShowSeats showslotseats=show.getShowSeatsByDate(ticketData.getDate());
		show.saveWithShow(showslotseats,ticketData.getTimeSlot(),-1*ticketData.getSeats());
		reservation.deleteReservation(ticketId);
		return "Reservation cancelled successfully";
	}
	
	
}
