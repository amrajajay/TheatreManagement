package com.theatreManagement.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.theatreManagement.project.entity.Reservation;

@Repository
public interface ReservationRespository extends CrudRepository<Reservation, String> {

}
