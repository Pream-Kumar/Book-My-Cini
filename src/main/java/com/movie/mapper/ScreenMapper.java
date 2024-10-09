package com.movie.mapper;

import org.springframework.stereotype.Component;

import com.movie.dto.ScreenDto;
import com.movie.model.Screen;

@Component
public class ScreenMapper {
	public static ScreenDto toDto(Screen screen) {
		ScreenDto screenDto = new ScreenDto();
		screenDto.setScreenId(screen.getScreenId());
		screenDto.setScreenNumber(screen.getScreenNumber());
		screenDto.setCapacity(screen.getCapacity());
		return screenDto;
	}

	public static Screen toEntity(ScreenDto screenDto) {
		Screen screen = new Screen();
		screen.setScreenId(screenDto.getScreenId());
		screen.setScreenNumber(screenDto.getScreenNumber());
		screen.setCapacity(screenDto.getCapacity());
		return screen;
	}
}
