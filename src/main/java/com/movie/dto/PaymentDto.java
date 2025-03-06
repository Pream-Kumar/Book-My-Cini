package com.movie.dto;

import com.movie.enums.PaymentMethod;
import com.movie.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	private Long paymentId;
	private String paymentReference;
	private Double amount;
	private Integer quantity;
	private String currency;
	private PaymentStatus status;
	private PaymentMethod method;
	private Date paymentDate;
	private Long bookingId;
	private String transactionId;
	private String failureReason;
	private Long movieId;
	private String movieTitle;
}