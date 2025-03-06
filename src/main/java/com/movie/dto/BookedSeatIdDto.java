package com.movie.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookedSeatIdDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long booking;
	private Long seat;

	public Long getBooking() {
		return booking;
	}

	public void setBooking(Long booking) {
		this.booking = booking;
	}

	public Long getSeat() {
		return seat;
	}

	public void setSeat(Long seat) {
		this.seat = seat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Constructors, equals(), and hashCode()
}
