package com.movie.mapper;

import com.movie.dto.ShowtimeDto;
import com.movie.model.Showtime;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ShowtimeMapper {
	public static ShowtimeDto toDTO(Showtime showtime) {
		ShowtimeDto showtimeDto = new ShowtimeDto();
		showtimeDto.setShowtimeId(showtime.getShowtimeId());
		showtimeDto.setStartTime(LocalTime.from(LocalDateTime.from(showtime.getStartTime())));
		showtimeDto.setEndTime(LocalDateTime.from(showtime.getEndTime()));
		return showtimeDto;
	}
	
	
	public static Showtime toEntity(ShowtimeDto showtimeDto) {
		Showtime showtime = new Showtime();
		showtime.setShowtimeId(showtimeDto.getShowtimeId());
		showtime.setStartTime(showtimeDto.getStartTime());
		showtime.setEndTime(showtimeDto.getEndTime());
		return showtime;
	}
}
