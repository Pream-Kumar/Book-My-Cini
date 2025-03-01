package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

}
