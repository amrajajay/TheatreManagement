package com.theatreManagement.project.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.theatreManagement.project.entity.ShowSeats;

@Repository
public interface ShowSeatsRepository extends CrudRepository<ShowSeats, Date> {

}
