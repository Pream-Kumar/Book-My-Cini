package com.movie.service;

import com.movie.model.Seat;
import com.movie.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepo;

    public List<Seat> getAllSeats() {
        return seatRepo.findAll();
    }

    public Optional<Seat> getSeatById(Long seatId) {
        return seatRepo.findById(seatId);
    }

    public Seat addNewSeat(Seat seat) {
        return seatRepo.save(seat);
    }

    public Seat updateSeat(Long seatId, Seat updatedSeat) {
        return seatRepo.findById(seatId)
                .map(seat -> {
                    seat.setSeatNumber(updatedSeat.getSeatNumber());
                    seat.setType(updatedSeat.getType());
                    seat.setPrice(updatedSeat.getPrice());
                    seat.set_booked(updatedSeat.is_booked());
                    return seatRepo.save(seat);
                })
                .orElseThrow(() -> new RuntimeException("Seat not found"));
    }

    public void deleteSeat(Long seatId) {
        seatRepo.deleteById(seatId);
    }

    public List<Seat> getSeatsByScreenId(Long screenId) {
        return seatRepo.findByScreen_ScreenId(screenId);
    }

    public boolean isSeatAvailable(Long seatId) {
        Optional<Seat> seat = seatRepo.findById(seatId);
        return seat.map(s -> !s.is_booked()).orElse(false);
    }


    public Seat bookSeat(Long seatId) {
        Seat seat = seatRepo.findById(seatId).orElseThrow(() -> new RuntimeException("Seat not found"));
        if (seat.is_booked()) {
            throw new RuntimeException("Seat is already booked");
        }
        seat.set_booked(true);
        return seatRepo.save(seat);
    }


    // Fetch available seats (not booked)
    public List<Seat> getAvailableSeats(Long screenId) {
        return seatRepo.findByScreenIdAndIsBookedFalse(screenId);
    }

    // Book selected seats
    public List<Seat> bookSeats(List<Long> seatIds) {
        List<Seat> seats = seatRepo.findAllById(seatIds);

        // Check if all selected seats are available
        for (Seat seat : seats) {
            if (seat.is_booked()) {
                throw new RuntimeException("Seat " + seat.getSeatNumber() + " is already booked!");
            }
        }

        // Mark seats as booked
        seats.forEach(seat -> seat.set_booked(true));

        return seatRepo.saveAll(seats);
    }

}
