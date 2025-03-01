package com.movie.dto;

import java.time.LocalDateTime;
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
public class ShowtimeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieDto movie;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private ScreenDto screen;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "showtime")
    private List<BookingDto> bookings;

    // Constructors, Getters, Setters
}
