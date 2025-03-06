package com.movie.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto {

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDateTime createdAt;
    private List<BookingDto> bookings;

    // Constructors, Getters, Setters
}
