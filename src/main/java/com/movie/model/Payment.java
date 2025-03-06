package com.movie.model;

import com.movie.enums.PaymentMethod;
import com.movie.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "payments")
@Data
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payment_id;

	@OneToOne
	private Movie movie;

	@Column(nullable = false)
	private String paymentReference; // Unique transaction reference

	@Column(nullable = false)
	private Double amount;

	@Column(nullable = false)
	private Integer quantity;

	@Column(nullable = false)
	private String currency;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentStatus status; // Enum: PENDING, COMPLETED, FAILED, REFUNDED

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentMethod method; // Enum: CREDIT_CARD, DEBIT_CARD, UPI, NET_BANKING, WALLET

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date paymentDate;

	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking; // Link to Booking entity

	@Column(nullable = false)
	private String transactionId; // External transaction ID from the payment gateway

	@Column
	private String failureReason; // Reason if payment fails

	// Constructors, Getters, and Setters
}
