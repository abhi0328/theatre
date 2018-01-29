package com.app.theatre;

import java.util.ArrayList;
import java.util.List;

public class Row {

	private List<Section> sections = new ArrayList<>();

	private int rowNum;

	public Row(final int rowNum) {
		this.rowNum = rowNum;
	}

	public Row(List<Section> sections) {
		this.sections = sections;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void addSection(Section section) {
		sections.add(section);
	}

	@Override
	public String toString() {
		return "Row " + rowNum;
	}

}