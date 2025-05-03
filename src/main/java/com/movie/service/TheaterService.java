package com.movie.service;

import com.movie.model.Screen;
import com.movie.model.Seat;
import com.movie.model.Theater;
import com.movie.repository.ScreenRepository;
import com.movie.repository.SeatRepository;
import com.movie.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
	@Autowired
	private TheaterRepository theaterRepo;
	@Autowired
	private ScreenRepository screenRepo;
	@Autowired
	private SeatRepository seatRepo;
	
	public Theater addNewTheater(Theater theater){
		Theater existingTheater = theaterRepo.findByName(theater.getName()).orElse(null);
		if (existingTheater != null) {
			return existingTheater; // Theater already exists, return it
		}
		theater = theaterRepo.save(theater); // Save the new theater
		generateScreenForTheater(theater); // Generate screen and seats for the new theater
		return theater;
	} // Create

	private void generateScreenForTheater(Theater theater) {

		int screenCount = theater.getNumberOfScreens();

		for (int i = 0; i < screenCount; i++) {
		Screen screen = new Screen();
		screen.setTheater(theater);
		screen.setScreenName("Screen "+ (i+1));
		screen = screenRepo.save(screen);
		generateSeatsForScreen(screen);
		}
	}

	private void generateSeatsForScreen(Screen screen) {
		List<Seat> seats = new ArrayList<>();
		for (char row = 'A'; row <= 'Z'; row++) {
			for (int number = 1; number <= 10; number++) {
				Seat seat = new Seat();
				seat.setSeatNumber("" + row + number); // e.g., A1, B5
				seat.setType("Standard"); // Default type
				seat.setBooked(false);
				seat.setScreen(screen);
				seat.setPrice(120.00); // Default price, can be customized
				seats.add(seat);
			}
		}
		seatRepo.saveAll(seats);
	}

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
