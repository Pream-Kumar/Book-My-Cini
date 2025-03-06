package com.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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

//    @OneToMany(mappedBy = "movie")
//    private List<Showtime> showtimes;

    

}
