package com.movie.mapper;

import com.movie.dto.PaymentDto;
import com.movie.model.Payment;

public class PaymentMapper {
	public static PaymentDto toDto(Payment payment) {
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setPaymentId(payment.getPaymentId());
		paymentDto.setAmountPaid(payment.getAmountPaid());
		paymentDto.setPaymentMethod(payment.getPaymentMethod());
		paymentDto.setPaymentStatus(payment.getPaymentStatus());
		paymentDto.setPaymentDate(payment.getPaymentDate());
		return paymentDto;
	}
	
	public static Payment toEntity(PaymentDto paymentDto) {
		Payment payment = new Payment();
		payment.setPaymentId(paymentDto.getPaymentId());
		payment.setAmountPaid(paymentDto.getAmountPaid());
		payment.setPaymentMethod(paymentDto.getPaymentMethod());
		payment.setPaymentStatus(paymentDto.getPaymentStatus());
		payment.setPaymentDate(paymentDto.getPaymentDate());
		return payment;
	}
}
