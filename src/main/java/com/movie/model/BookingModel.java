package com.movie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class BookingModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "showtime_id")
	private Showtime showtime;

	private LocalDateTime bookingDate;
	private double totalPrice;

	@OneToMany(mappedBy = "booking")
	private List<BookedSeat> bookedSeats;

	@OneToOne(mappedBy = "booking")
	private Payment payment;


	// Constructors, Getters, Setters

}
