package com.movie.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;
    
    @ManyToOne
    private Screen screen;

    private String seatNumber;
    private String type; // Standard, VIP, etc.
    private double price;

    @OneToMany(mappedBy = "seat")
    private List<BookedSeat> bookedSeats;
    
    private boolean isBooked;

    // Constructors, Getters, Setters
}
