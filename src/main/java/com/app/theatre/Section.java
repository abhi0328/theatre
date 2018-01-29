package com.app.theatre;

import java.util.List;

public class Section {

	private List<Seat> seats;
	
	private int sectionNumber;

	public Section(final int sectionNumber, final List<Seat> seats) {
		this.sectionNumber = sectionNumber;
		this.seats = seats;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Section " + sectionNumber;
	}
}