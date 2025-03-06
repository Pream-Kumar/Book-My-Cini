package com.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Theater;
import com.movie.repository.TheaterRepository;

@Service
public class TheaterService {
	@Autowired
	private TheaterRepository theaterRepo;
	
	public Theater addNewTheater(Theater theater){
		return theaterRepo.save(theater);
	} // Create
	
	public List<Theater> getAllTheater() {
		return theaterRepo.findAll();
	} // Read All
	
	public Optional<Theater> getTheaterById(Long id){
		return theaterRepo.findById(id);
	} // Read by Id
	
	public Optional<Theater> getTheaterByName(String name){
		return theaterRepo.findByName(name);
	} // Read by Name
	
	public String deleteTheater(Long theaterId) {
		if(theaterRepo.getReferenceById(theaterId) != null) {
        	theaterRepo.deleteById(theaterId);
        }
		else {
			return "Theater does not exist";
		}
		return "Theater deleted successfully";
//		movieRepo.deleteById(movieId);
	}
}
