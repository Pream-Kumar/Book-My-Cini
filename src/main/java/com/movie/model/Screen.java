package com.movie.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "screenId")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    @JsonBackReference
    private Theater theater;

    private int screenNumber;
    private int capacity;
//    @JsonManagedReference
    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;

    @OneToMany(mappedBy = "screen")
    private List<Showtime> showtimes;

    // Constructors, Getters, Setters
    
}
