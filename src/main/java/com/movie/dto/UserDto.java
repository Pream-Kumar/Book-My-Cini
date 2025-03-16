package com.movie.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDateTime createdAt;
    private String roleName;
    private List<BookingDto> bookings;

    // Constructors, Getters, Setters
}
