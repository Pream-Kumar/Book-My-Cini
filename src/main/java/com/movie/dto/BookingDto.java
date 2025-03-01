package com.movie.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.movie.model.Payment;
import com.movie.model.Showtime;
import com.movie.model.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDto {
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
    private List<BookedSeatDto> bookedSeats;

    @OneToOne(mappedBy = "booking")
    private Payment payment;

    // Constructors, Getters, Setters
}
