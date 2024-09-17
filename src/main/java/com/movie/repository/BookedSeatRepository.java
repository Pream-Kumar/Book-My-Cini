package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.model.BookedSeat;
import com.movie.model.BookedSeatId;

@Repository
public interface BookedSeatRepository extends JpaRepository<BookedSeat, BookedSeatId> {

}
