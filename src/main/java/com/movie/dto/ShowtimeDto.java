package com.movie.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Data
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

    private LocalTime startTime;
    private LocalTime endTime;

    @OneToMany(mappedBy = "showtime")
    private List<BookingDto> bookings;

	public Long getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Long showtimeId) {
		this.showtimeId = showtimeId;
	}

	public MovieDto getMovie() {
		return movie;
	}

	public void setMovie(MovieDto movie) {
		this.movie = movie;
	}

	public ScreenDto getScreen() {
		return screen;
	}

	public void setScreen(ScreenDto screen) {
		this.screen = screen;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = LocalTime.from(endTime);
	}

	public List<BookingDto> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDto> bookings) {
		this.bookings = bookings;
	}

    // Constructors, Getters, Setters


}
