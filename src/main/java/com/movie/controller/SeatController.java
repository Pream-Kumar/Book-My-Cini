package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Seat;
import com.movie.service.SeatService;

@RestController
public class SeatController {
	
	@Autowired
	private SeatService seatService;
	
	@PostMapping("/createSeatData")
	private Seat createSeatData(@RequestBody Seat seat) {
		return seatService.createSeatData(seat);
	}
}
