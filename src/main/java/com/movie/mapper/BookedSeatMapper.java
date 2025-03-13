package com.movie.mapper;

import com.movie.dto.BookedSeatDto;
import com.movie.model.BookedSeat;

public class BookedSeatMapper {

    public static BookedSeatDto toDto(BookedSeat bookedSeat) {
        BookedSeatDto BookedSeatDto = new BookedSeatDto();
//        BookedSeatDto.setBookedSeatId(BookedSeatIdMapper.toDTO(bookedSeat.getBookedSeatId()));


        return BookedSeatDto;
    }

    public static BookedSeat toEntity(BookedSeatDto BookedSeatDto) {
        BookedSeat bookedSeat = new BookedSeat();
//        bookedSeat.setBookedSeatId(BookedSeatIdMapper.toEntity(BookedSeatDto.getBookedSeatId()));


        return bookedSeat;
    }
}
