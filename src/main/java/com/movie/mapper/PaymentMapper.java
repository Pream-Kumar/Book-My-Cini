package com.movie.mapper;

import com.movie.dto.PaymentDto;
import com.movie.model.Payment;

public class PaymentMapper {

	public static PaymentDto toDTO(Payment payment) {
		PaymentDto dto = new PaymentDto();
		dto.setPaymentId(payment.getPayment_id());
		dto.setPaymentReference(payment.getPaymentReference());
		dto.setAmount(payment.getAmount());
		dto.setQuantity(payment.getQuantity());
		dto.setCurrency(payment.getCurrency());
		dto.setStatus(payment.getStatus());
		dto.setMethod(payment.getMethod());
		dto.setPaymentDate(payment.getPaymentDate());
		dto.setBookingId(payment.getBooking().getBookingId());
		dto.setTransactionId(payment.getTransactionId());
		dto.setFailureReason(payment.getFailureReason());
		if (payment.getMovie() != null) {
			dto.setMovieId(payment.getMovie().getMovieId());
			dto.setMovieTitle(payment.getMovie().getTitle());
		}
		return dto;
	}

	public static Payment toEntity(PaymentDto dto) {
		Payment payment = new Payment();
		payment.setPayment_id(dto.getPaymentId());
		payment.setPaymentReference(dto.getPaymentReference());
		payment.setAmount(dto.getAmount());
		payment.setQuantity(dto.getQuantity());
		payment.setCurrency(dto.getCurrency());
		payment.setStatus(dto.getStatus());
		payment.setMethod(dto.getMethod());
		payment.setPaymentDate(dto.getPaymentDate());
		payment.setTransactionId(dto.getTransactionId());
		payment.setFailureReason(dto.getFailureReason());
		return payment;
	}
}
