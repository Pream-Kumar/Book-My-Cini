package com.movie.dto;

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
public class SeatDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private ScreenDto screen;

    private String seatNumber;
    private String type; // Standard, VIP, etc.
    private double price;

    @OneToMany(mappedBy = "seat")
    private List<BookedSeatDto> bookedSeats;

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public ScreenDto getScreen() {
		return screen;
	}

	public void setScreen(ScreenDto screen) {
		this.screen = screen;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<BookedSeatDto> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<BookedSeatDto> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

    // Constructors, Getters, Setters
    
    
}
