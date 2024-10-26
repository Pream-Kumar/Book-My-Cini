package com.movie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Seat;
import com.movie.service.SeatService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/seat")
public class SeatController {
	 @Autowired
	    private SeatService seatService;

	    // Get all seats
	    @GetMapping("/getAllSeats")
	    public List<Seat> getAllSeats() {
	        return seatService.getAllSeats();
	    }

	    // Get seats by screen ID
	    @GetMapping("/getSeatsByScreen/{screenId}")
	    public List<Seat> getSeatsByScreen(@PathVariable Long screenId) {
	        return seatService.getSeatsByScreen(screenId);
	    }

	    // Get a seat by ID
	    @GetMapping("/getSeatById/{seatId}")
	    public ResponseEntity<Seat> getSeatById(@PathVariable Long seatId) {
	        Optional<Seat> seat = seatService.getSeatById(seatId);
	        return seat.map(ResponseEntity::ok)
	                   .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }

	    // Add a new seat
	    @PostMapping("/addSeat")
	    public ResponseEntity<Seat> addSeat(@RequestBody Seat seat) {
	        Seat newSeat = seatService.addSeat(seat);
	        return ResponseEntity.status(HttpStatus.CREATED).body(newSeat);
	    }

	    // Delete a seat
	    @DeleteMapping("/deleteSeat/{seatId}")
	    public ResponseEntity<Void> deleteSeat(@PathVariable Long seatId) {
	        Optional<Seat> seat = seatService.getSeatById(seatId);
	        if (seat.isPresent()) {
	            seatService.deleteSeat(seatId);
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
}
