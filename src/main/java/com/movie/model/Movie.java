package com.movie.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    private String genre;
    private LocalDate releaseDate;
    private int duration; // in minutes
    private double rating;
    private String language;
    private String description;

    @OneToMany(mappedBy = "movie")
    private List<Showtime> showtimes;
    
    @ManyToMany
    private List<Theater> movieRunningTheaters;

}
