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
    private List<SeatDto> seatDtos;

    @OneToMany(mappedBy = "screen")
    private List<Showtime> showtimes;

	public Long getScreenId() {
		return screenId;
	}

	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public int getScreenNumber() {
		return screenNumber;
	}

	public void setScreenNumber(int screenNumber) {
		this.screenNumber = screenNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<SeatDto> getSeatDtos() {
		return seatDtos;
	}

	public void setSeatDtos(List<SeatDto> seatDtos) {
		this.seatDtos = seatDtos;
	}

	public List<Showtime> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<Showtime> showtimes) {
		this.showtimes = showtimes;
	}

    // Constructors, Getters, Setters
}
