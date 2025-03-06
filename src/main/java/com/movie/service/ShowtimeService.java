package com.movie.service;

import com.movie.model.Screen;
import com.movie.model.Showtime;
import com.movie.model.Theater;
import com.movie.repository.ScreenRepository;
import com.movie.repository.ShowtimeRepository;
import com.movie.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepo;

    @Autowired
    private TheaterRepository theaterRepo;

    @Autowired
    private ScreenRepository screenRepo;

    public List<Showtime> getAllShowtime() {
        return showtimeRepo.findAll();
    }


    public Optional<Showtime> getShowtimeById(Long id) {
        return showtimeRepo.findById(id);
    }

    public Showtime addShowtime(Long theaterId, Long screenId, LocalDateTime startTime) {
        Optional<Theater> theater = theaterRepo.findById(theaterId);
        Optional<Screen> screen = screenRepo.findById(screenId);

        if (theater.isPresent() && screen.isPresent()) {
            // Calculate end time (Show duration = 3 hours)
            LocalDateTime endTime = startTime.plusHours(3);

            // Check if the screen is available (1-hour interval check)
            List<Showtime> existingShowtimes = showtimeRepo.findByScreenId(screenId);
            for (Showtime existingShowtime : existingShowtimes) {
                if (startTime.isBefore(existingShowtime.getEndTime().plusHours(1)) &&
                        endTime.isAfter(existingShowtime.getStartTime())) {
                    throw new RuntimeException("Screen is not available at this time!");
                }
            }

            // Save new showtime
            Showtime showtime = new Showtime();
            showtime.setTheater(theater.get());
            showtime.setScreen(screen.get());
            showtime.setStartTime(startTime);
            showtime.setEndTime(endTime);
            return showtimeRepo.save(showtime);
        } else {
            throw new RuntimeException("Theater or Screen not found!");
        }
    }

    public void deleteShowtime(Long id) {
        showtimeRepo.deleteById(id);
    }
}
