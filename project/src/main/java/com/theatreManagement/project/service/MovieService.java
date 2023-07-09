package com.theatreManagement.project.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theatreManagement.project.entity.Movie;
import com.theatreManagement.project.entity.ShowSeats;
import com.theatreManagement.project.repository.MovieRepository;

@Service
public class MovieService {
	static Map<String,String> timings =new HashMap<>();
	static {
	timings.put("a","11Am");
	timings.put("b","2Pm");
	timings.put("c","6Pm");
	timings.put("d","9Pm");
	}
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ShowSeatsService seatsService;

	public List<Movie> getAllMovies(){
		return (List<Movie>) movieRepository.findAll();
	}
	
	public Movie findByMovieId(int id){
		return movieRepository.findById(id).orElse(null);
	}
	public List<Movie> getMovies() {
		List<Movie> movies = getAllMovies();
		if(movies == null || movies.size() ==0) return null;
		for(Movie i:movies) {
			String times="";
			for(String j:i.getTime().split(""))
				times+=timings.get(j)+",";
			
			i.setTimeSlots(times.substring(0,times.length()-1));
	
		}
		return movies;
		
	}
	public Movie getMovieDetaisByMovieName(String name) {
//		 return (Movie) getAllMovies().stream().filter(i-> i.getName().equals(name));
		List<Movie> list= getAllMovies();
		for(Movie i:list)
			if(i.getName().equalsIgnoreCase(name))
				return i;
		return null;
		
		 
	}
	public boolean checkMovieAvaliable(String name,Date date,String slot,int seats)throws Exception {
		Movie movie = getMovieDetaisByMovieName(name);
		if(movie == null) throw new Exception("Movie name not found");
		if(!(date.after(movie.getFromDate()) && date.before(movie.getToDate()))) throw new Exception("Movie not avaliable in given date");
		ShowSeats showslotseats = seatsService.getShowSeatsByDate(date);
		if(showslotseats != null) {
			
			int avaliableSeats = 0;
			if(slot.equals("11Am")) avaliableSeats = showslotseats.getMorningShow();
			if(slot.equals("2Pm")) avaliableSeats = showslotseats.getMatineeShow();
			if(slot.equals("6Pm")) avaliableSeats = showslotseats.getFirstShow();
			if(slot.equals("9Pm")) avaliableSeats = showslotseats.getSecondShow();
			if(seats > avaliableSeats) { 
				throw new Exception("Seats are not avalibale\nAvaliable seats for the slot: "+slot+" are "+avaliableSeats);
			}
			
		}
		else {
			seatsService.save(new ShowSeats(date,100,100,100,100));
		}
		return true;
		
	}
}
