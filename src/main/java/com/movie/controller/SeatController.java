package com.movie.controller;

import com.movie.model.Seat;
import com.movie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/getAllSeats")
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/getSeatById/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long seatId) {
        Optional<Seat> seat = seatService.getSeatById(seatId);
        return seat.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/addSeat")
    public Seat addNewSeat(@RequestBody Seat seat) {
        return seatService.addNewSeat(seat);
    }

    @PutMapping("/updateSeat/{seatId}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Long seatId, @RequestBody Seat updatedSeat) {
        return ResponseEntity.ok(seatService.updateSeat(seatId, updatedSeat));
    }

    @DeleteMapping("/deleteSeat/{seatId}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long seatId) {
        seatService.deleteSeat(seatId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getSeatsByScreen/{screenId}")
    public List<Seat> getSeatsByScreen(@PathVariable Long screenId) {
        return seatService.getSeatsByScreenId(screenId);
    }

    @GetMapping("/checkAvailability/{seatId}")
    public boolean checkSeatAvailability(@PathVariable Long seatId) {
        return seatService.isSeatAvailable(seatId);
    }

    @PutMapping("/bookSeat/{seatId}")
    public ResponseEntity<Seat> bookSeat(@PathVariable Long seatId) {
        return ResponseEntity.ok(seatService.bookSeat(seatId));
    }


    // Get available seats for a screen
    @GetMapping("/available/{screenId}")
    public ResponseEntity<List<Seat>> getAvailableSeats(@PathVariable Long screenId) {
        List<Seat> availableSeats = seatService.getAvailableSeats(screenId);
        return ResponseEntity.ok(availableSeats);
    }
    // Book selected seats
    @PostMapping("/book")
    public ResponseEntity<?> bookSeats(@RequestBody List<Long> seatIds) {
        try {
            List<Seat> bookedSeats = seatService.bookSeats(seatIds);
            return ResponseEntity.ok(bookedSeats);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
