//package com.movie.mapper;
//
//import com.movie.dto.SeatDto;
//import com.movie.model.Seat;
//
//public class SeatMapper {
//	
//	public static SeatDto toDto(Seat seat) {
//		SeatDto seatDto = new SeatDto();
//		seatDto.setSeatId(seat.getSeatId());
//		seatDto.setSeatNumber(seat.getSeatNumber());
//		seatDto.setType(seat.getType());
//		seatDto.setPrice(seat.getPrice());
//		return seatDto;
//	}
//	
//	public static Seat toEntity(SeatDto seatDto) {
//		Seat seat = new Seat();
//		seat.setSeatId(seatDto.getSeatId());
//		seat.setSeatNumber(seatDto.getSeatNumber());
//		seat.setType(seatDto.getType());
//		seat.setPrice(seatDto.getPrice());
//		return seat;
//	}
//}
