package com.app.theatre;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

	private List<Row> rows = new ArrayList<Row>();
	
	private int totalEmptySeats;

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(final List<Row> rows) {
		this.rows = rows;
	}

	public void addRow(final Row row) {
		rows.add(row);
		totalEmptySeats += row.getSections().stream().map(Section::getSeats).mapToInt(List::size).sum();
	}

	public int getTotalEmptySeats() {
		return totalEmptySeats;
	}

}