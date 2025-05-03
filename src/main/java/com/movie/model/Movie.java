package com.movie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
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
    private String director;

    @OneToMany(mappedBy = "movie")
    private List<Showtime> showtimes;

    

}
