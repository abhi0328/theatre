package com.app.theatre;

public class PatronRequest {
	
	private String name;
	
	private int numTicketsRequested;

	private String response;

	public PatronRequest(final String name, final int tickets) {
		this.name = name;
		this.numTicketsRequested = tickets;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getNumTicketsRequested() {
		return numTicketsRequested;
	}

	public void setNumTicketsRequested(final int numTicketsRequested) {
		this.numTicketsRequested = numTicketsRequested;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(final String response) {
		this.response = response;
	}

}