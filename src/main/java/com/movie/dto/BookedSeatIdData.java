package com.movie.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookedSeatIdData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long booking;
    private Long seat;

    // Constructors, equals(), and hashCode()
}
