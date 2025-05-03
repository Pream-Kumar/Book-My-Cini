package com.movie.controller;

import com.movie.model.Theater;
import com.movie.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/theater")
public class TheaterController {
	
	@Autowired
	private TheaterService theaterService;
	
	@GetMapping("/getAllTheaters")
	public List<Theater> getAllTheater() {
		return theaterService.getAllTheater();
	}
	
	@GetMapping("/getTheaterById/{id}")
	public Optional<Theater> getTheaterById(@PathVariable Long id){
		return theaterService.getTheaterById(id);
	}
	
	@GetMapping("/getTheaterByName/{name}")
	public Optional<Theater> getTheaterByName(@PathVariable String name){
		return theaterService.getTheaterByName(name);
	}
	
	@PostMapping("/addNewTheater")
	public Theater addNewTheater(@RequestBody Theater theater) {
		return theaterService.addNewTheater(theater);
	}
	
	@DeleteMapping("/deleteTheater/{id}")
	public String deleteTheaterById(@PathVariable Long id) {
		String response = theaterService.deleteTheater(id);
		System.out.println(response);
		return response;

		
	}
	
}
