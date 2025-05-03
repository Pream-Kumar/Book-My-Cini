package com.movie.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDateTime createdAt;


    @OneToMany(mappedBy = "user")
    private List<BookingModel> bookings;
}
