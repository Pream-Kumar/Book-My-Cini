package com.movie.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookedSeatId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long booking;
    private Long seat;

    // Constructors, equals(), and hashCode()
}
