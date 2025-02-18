//package com.movie.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.movie.model.Seat;
//import com.movie.repository.SeatRepository;
//
//@Service
//public class SeatService {
//
//	@Autowired
//	private SeatRepository seatRepo;
//
//	public List<Seat> getAllSeats() {
//		return seatRepo.findAll();
//	}
//
//	public List<Seat> getSeatsByScreen(Long screenId) {
//		return seatRepo.findByScreenId(screenId);
//	}
//
//	public Optional<Seat> getSeatById(Long seatId) {
//		return seatRepo.findById(seatId);
//	}
//
//	public Seat addSeat(Seat seat) {
//		return seatRepo.save(seat);
//	}
//
//	public void deleteSeat(Long seatId) {
//		seatRepo.deleteById(seatId);
//	}
//
//}
