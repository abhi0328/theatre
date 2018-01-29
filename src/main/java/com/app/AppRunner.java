package com.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.app.theatre.LayoutProcessor;
import com.app.theatre.RequestProcessor;
import com.app.theatre.SeatAllocator;
import com.app.theatre.State;
import com.app.theatre.Theatre;

/**
 * Main Class to run the project
 *
 */
public class AppRunner {

	private static final String EMPTY_ROW = "";

	public static void main(String[] args) throws Exception {

		final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

		String input = null;

		final Theatre theatre = new Theatre();

		final RequestProcessor requestProcessor = new RequestProcessor();

		final LayoutProcessor layoutProcessor = new LayoutProcessor(theatre);

		State currentState = layoutProcessor;

		while ((input = inputReader.readLine()) != null) {
			if (!input.trim().equals(EMPTY_ROW)) {
				currentState.process(input);
			} else {
				if (currentState == layoutProcessor) {
					currentState = requestProcessor;
				} else {
					new SeatAllocator(theatre, requestProcessor.getRequests()).process();
					System.exit(0);
				}
			}
		}
	}

}