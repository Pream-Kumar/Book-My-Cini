package com.movie.mapper;

import com.movie.dto.BookedSeatIdDto;
import com.movie.model.BookedSeatId;

public class BookedSeatIdMapper {
	public static BookedSeatIdDto toDto(BookedSeatId bookedSeatId) {
		BookedSeatIdDto bookedSeatIdDto = new BookedSeatIdDto();
		bookedSeatIdDto.setBooking(bookedSeatId.getBooking());
		bookedSeatIdDto.setSeat(bookedSeatId.getSeat());
		return bookedSeatIdDto;
}
	public static BookedSeatId toEntity(BookedSeatIdDto bookedSeatIdDto) {
		BookedSeatId bookedSeatId = new BookedSeatId();
		bookedSeatId.setBooking(bookedSeatIdDto.getBooking());
		bookedSeatId.setSeat(bookedSeatIdDto.getSeat());
		return bookedSeatId;
	}
}
