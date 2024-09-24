package com.movie.dto;

import com.movie.model.BookedSeatId;
import com.movie.model.Booking;

import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@IdClass(BookedSeatId.class)
public class BookedSeatData {

    @Id
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Id
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    // Constructors, Getters, Setters
}
