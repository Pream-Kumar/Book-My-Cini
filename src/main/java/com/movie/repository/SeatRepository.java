package com.movie.repository;

import com.movie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByScreen_ScreenIdAndIsBookedFalse(Long screenId);

    List<Seat> findByScreen_ScreenId(Long screenId);

    Optional<Seat> findBySeatId(Long seatId);

}
