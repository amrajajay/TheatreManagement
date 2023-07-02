package com.theatreManagement.project.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theatreManagement.project.entity.ShowSeats;
import com.theatreManagement.project.repository.ShowSeatsRepository;

@Service
public class ShowSeatsService {
	@Autowired
	private ShowSeatsRepository seatsRepo;

	public List<ShowSeats> getAllDateShowSeats(){
		return (List<ShowSeats>) seatsRepo.findAll();
	}
	public ShowSeats getShowSeatsByDate(Date date) {
		return seatsRepo.findById(date).orElse(null);
	}
	
	
	
	public void saveWithShow(ShowSeats showSeats,String slot, int seats) {

		if(slot.equals("11Am")) showSeats.setMorningShow(showSeats.getMorningShow()-seats);
		else if(slot.equals("2Pm"))showSeats.setMatineeShow(showSeats.getMatineeShow()-seats);
		else if(slot.equals("6Pm")) showSeats.setFirstShow(showSeats.getFirstShow()-seats);
		else showSeats.setSecondShow(showSeats.getSecondShow()-seats);
		seatsRepo.save(showSeats);
	}
	public String getSlotfromTime(String s) {
		if(s.equals("11Am")) return "morning";
		else if(s.equals("2Pm")) return "matinee";
		else if(s.equals("6Pm")) return "first";
		else return "second";
	}
	 
	
	
}
