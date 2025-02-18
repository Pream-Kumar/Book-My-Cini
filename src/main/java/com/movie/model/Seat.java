package com.movie.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;
    private String seatNumber;
    private String type; // Standard, VIP, etc.
    private double price;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
    
    @OneToMany(mappedBy = "seat")
    private List<BookedSeat> bookedSeats;


    // Constructors, Getters, Setters
    
    
}
