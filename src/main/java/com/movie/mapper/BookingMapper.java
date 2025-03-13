package com.movie.mapper;

import com.movie.dto.BookingDto;
import com.movie.model.Booking;

public class BookingMapper {
	public static BookingDto toDto(Booking booking) {
		BookingDto bookingDto = new BookingDto();
		bookingDto.setBookingId(booking.getBookingId());
		bookingDto.setBookingDate(booking.getBookingDate());
		bookingDto.setTotalPrice(booking.getTotalPrice());
		return bookingDto;
}
	public static Booking toEntity(BookingDto bookingDto) {
		Booking booking = new Booking();
		booking.setBookingId(bookingDto.getBookingId());
		booking.setBookingDate(bookingDto.getBookingDate());
		booking.setTotalPrice(bookingDto.getTotalPrice());
		return booking;
	}
}