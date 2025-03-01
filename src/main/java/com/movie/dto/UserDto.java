package com.movie.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<BookingDto> bookings;

    // Constructors, Getters, Setters
}
