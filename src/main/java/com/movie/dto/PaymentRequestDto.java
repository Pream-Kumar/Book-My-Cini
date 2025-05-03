package com.movie.dto;

import com.movie.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {
        private Long bookingId; // The booking for which payment is made
        private Double amount;  // The total amount to be paid
        private String currency;
        private PaymentMethod method; // Credit Card, UPI, PayPal, etc.
    }
