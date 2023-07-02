package com.theatreManagement.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.theatreManagement.project.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
