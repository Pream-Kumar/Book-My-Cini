package com.movie.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;

    private String name;
    private String location;
    private int numberOfScreens;

    @OneToMany(mappedBy = "theater")
    @JsonManagedReference
    private List<Screen> screens;

//    @OneToMany(mappedBy = "theater")
//    private List<Showtime> showtime;

    // Constructors, Getters, Setters
}
