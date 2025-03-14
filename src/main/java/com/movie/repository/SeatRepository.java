package com.movie.repository;

import com.movie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

//    @Query("SELECT s FROM Seat s WHERE s.screen.id = :screenId AND s.isBooked = false")
//    List<Seat> findAvailableSeats(@Param("screenId") Long screenId);

    List<Seat> findByScreen_ScreenIdAndBookedFalse(Long screenId);
   // List<Seat> findByScreen_ScreenIdAndIsBookedFalse(Long screenId);

    List<Seat> findByScreen_ScreenId(Long screenId);


}
