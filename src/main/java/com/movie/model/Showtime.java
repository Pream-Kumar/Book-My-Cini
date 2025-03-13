package com.movie.model;

import java.time.LocalDateTime;
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

@Data
@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;

//    @ManyToOne
//    @JoinColumn(name = "movie_id")
//    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_showtime")
    private Screen screen;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "showtime")
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;


    // Constructors, Getters, Setters
    
    
}
