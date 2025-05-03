package com.movie.repository;

import com.movie.model.BookedSeat;
import com.movie.model.BookedSeatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedSeatRepository extends JpaRepository<BookedSeat, BookedSeatId> {

}
