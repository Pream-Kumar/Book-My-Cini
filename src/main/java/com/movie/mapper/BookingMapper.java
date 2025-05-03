package com.movie.mapper;

import com.movie.dto.BookingDto;
import com.movie.model.BookingModel;


public class BookingMapper {
	public static BookingDto toDto(BookingModel booking) {
		BookingDto bookingDto = new BookingDto();
		bookingDto.setBookingId(booking.getBookingId());
		bookingDto.setBookingDate(booking.getBookingDate());
		bookingDto.setTotalPrice(booking.getTotalPrice());
		return bookingDto;
}
	public static BookingModel toEntity(BookingDto bookingDto) {
		BookingModel booking = new BookingModel();
		booking.setBookingId(bookingDto.getBookingId());
		booking.setBookingDate(bookingDto.getBookingDate());
		booking.setTotalPrice(bookingDto.getTotalPrice());
		return booking;
	}
}