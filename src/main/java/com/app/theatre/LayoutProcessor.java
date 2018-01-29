package com.app.theatre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LayoutProcessor implements State {

	private Theatre theatre;

	public LayoutProcessor(final Theatre theatre) {
		this.theatre = theatre;
	}

	@Override
	public void process(final String input) {
		final int[] sections = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

		final Row row = new Row(theatre.getRows().size() + 1);
		for (int i = 0; i < sections.length; i++) {
			final Section section = new Section(i + 1,
					new ArrayList<Seat>(Collections.nCopies(sections[i], new Seat())));
			row.addSection(section);
		}
		theatre.addRow(row);
	}

}