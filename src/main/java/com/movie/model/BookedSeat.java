package com.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@IdClass(BookedSeatId.class)
@Data
public class BookedSeat {

    @Id
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingModel booking;

    @Id
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    // Constructors, Getters, Setters
}
