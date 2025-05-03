package com.movie.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequestDto {
    private Long userId;
    private Long showtimeId;
    private List<Long> seatIds;
}
