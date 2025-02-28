package com.movie.dto;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private BookingDto booking;

    private double amountPaid;
    private String paymentMethod; // Credit Card, PayPal, etc.
    private String paymentStatus; // Success, Pending, Failed
    private LocalDateTime paymentDate;

    // Constructors, Getters, Setters
}
