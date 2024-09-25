package com.movie.dto;

import java.time.LocalDate;
import java.util.List;

import com.movie.model.Showtime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {
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

}
