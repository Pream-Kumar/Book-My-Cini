package com.movie.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_showtime")
    private Screen screen;

    private LocalDate showDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @OneToMany(mappedBy = "showtime")
    private List<BookingModel> bookings;

//    @ManyToOne
//    @JoinColumn(name = "theater_id")
//    private Theater theater;


    // Constructors, Getters, Setters
    
    
}
