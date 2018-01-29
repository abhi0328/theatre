package com.app.theatre;

import java.util.ArrayList;
import java.util.List;

import com.app.exception.InvalidTicketRequestException;

public class RequestProcessor implements State {

	private final List<PatronRequest> requests = new ArrayList<>();

	public List<PatronRequest> getRequests() {
		return requests;
	}

	@Override
	public void process(final String input) {
		final String[] details = input.split(" ");
		if (details.length < 2) {
			throw new InvalidTicketRequestException("Invalid ticket request");
		} else {
			requests.add(new PatronRequest(details[0], Integer.parseInt(details[1])));
		}
	}

}