package com.movie.mapper;

import org.springframework.stereotype.Component;
import com.movie.dto.ScreenDto;
import com.movie.model.Screen;

@Component
public class ScreenMapper {

    public ScreenDto toDto(Screen screen) {
        if (screen == null) {
            return null;
        }
        ScreenDto screenDto = new ScreenDto();
        screenDto.setScreenId(screen.getScreenId());
        screenDto.setScreenNumber(screen.getScreenNumber());
        screenDto.setCapacity(screen.getCapacity());
        return screenDto;
    }

    public Screen toEntity(ScreenDto screenDto) {
        if (screenDto == null) {
            return null;
        }
        Screen screen = new Screen();
        screen.setScreenId(screenDto.getScreenId());
        screen.setScreenNumber(screenDto.getScreenNumber());
        screen.setCapacity(screenDto.getCapacity());
        return screen;
    }
}
