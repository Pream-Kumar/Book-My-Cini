package com.movie.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "seatId")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "screen_id")
    private Screen screen;

    private String seatNumber;
    private String type; // Standard, VIP, etc.
    private double price;
    private boolean is_booked;
    @OneToMany(mappedBy = "seat")
    private List<BookedSeat> bookedSeats;
}
