package com.movie.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookedSeatId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long booking;
    private Long seat;

    // Constructors, equals(), and hashCode()
}
