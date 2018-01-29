package com.app.exception;

public class InvalidTicketRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTicketRequestException(String message) {
		super(message);
	}
}
