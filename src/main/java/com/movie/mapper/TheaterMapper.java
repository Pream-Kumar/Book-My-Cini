package com.movie.mapper;

import com.movie.dto.TheaterDto;
import com.movie.model.Theater;

public class TheaterMapper {
	public static TheaterDto toDTO(Theater theater) {
		TheaterDto theaterDto = new TheaterDto();
		theaterDto.setTheaterId(theater.getTheaterId());
		theaterDto.setName(theater.getName());
		theaterDto.setLocation(theater.getLocation());
		theaterDto.setNumberOfScreens(theater.getNumberOfScreens());
		return theaterDto;
	}
	
	public static Theater toEntity(TheaterDto theaterDto) {
		Theater theater = new Theater();
		theater.setTheaterId(theaterDto.getTheaterId());
		theater.setName(theaterDto.getName());
		theater.setLocation(theaterDto.getLocation());
		theater.setNumberOfScreens(theaterDto.getNumberOfScreens());
		return theater;
	}
}
