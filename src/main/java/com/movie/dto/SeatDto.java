package com.movie.dto;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private ScreenDto screen;

    private String seatNumber;
    private String type; // Standard, VIP, etc.
    private double price;

    @OneToMany(mappedBy = "seat")
    private List<BookedSeatDto> bookedSeats;

    // Constructors, Getters, Setters
}
