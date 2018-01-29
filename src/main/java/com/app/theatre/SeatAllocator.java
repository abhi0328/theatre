package com.app.theatre;

import java.util.ArrayList;
import java.util.List;

public class SeatAllocator {

	final private Theatre theatre;

	final List<PatronRequest> requests;

	public SeatAllocator(final Theatre theatre, final List<PatronRequest> requests) {
		this.theatre = theatre;
		this.requests = requests;
	}

	public void process() {
		for (PatronRequest request : requests) {
			handleRequest(request);
			System.out.println(request.getResponse());
		}
	}

	private void handleRequest(final PatronRequest request) {

		final int ticketsRequested = request.getNumTicketsRequested();
		int totalEmptySeats = theatre.getTotalEmptySeats();
		
		if (totalEmptySeats >= ticketsRequested) {

			final List<Row> rows = theatre.getRows();
			for (Row row : rows) {
				for (Section section : row.getSections()) {
					if (section.getSeats().size() >= ticketsRequested) {
						final List<Seat> emptySeats = new ArrayList<>();
						for (Seat seat : section.getSeats()) {
							if (!seat.isBooked()) {
								emptySeats.add(seat);
							}

							// got the number of seats in this section
							if (emptySeats.size() == request.getNumTicketsRequested()) {
								// book the seats
								for (Seat seatToBook : emptySeats) {
									seatToBook.setBooked(true);
									totalEmptySeats--;
								}
								request.setResponse(request.getName() + " " + row + " " + section);
								return;
							}
						}
					}
				}
			}
			request.setResponse(request.getName() + " " + Constants.CALL_TO_SPLIT);
		} else {
			request.setResponse(request.getName() + " " + Constants.SORRY_CANNOT_HANDLE);
		}
	}

}