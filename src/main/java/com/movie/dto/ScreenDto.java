package com.movie.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.movie.model.Showtime;
import com.movie.model.Theater;

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
public class ScreenDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    @JsonBackReference
    private Theater theater;

    private int screenNumber;
    private int capacity;

    @OneToMany(mappedBy = "screen")
    private List<SeatDto> seats;

    @OneToMany(mappedBy = "screen")
    private List<Showtime> showtimes;

    // Constructors, Getters, Setters
}
