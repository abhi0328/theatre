package com.app.theatre;

import org.junit.Assert;
import org.junit.Test;

public class LayoutProcessorTest {

	/**
	 * Test for - Number of rows, Number of sections, Number of seats, Total Empty Seats
	 */
	@Test
	public void test1() {
		final Theatre theatre = new Theatre();
		LayoutProcessor processor = new LayoutProcessor(theatre);
		processor.process("6 6");
		
		Assert.assertEquals("Row 1", theatre.getRows().get(0).toString());
		Assert.assertEquals(1, theatre.getRows().size());
		Assert.assertEquals(2, theatre.getRows().get(0).getSections().size());
		Assert.assertEquals(6, theatre.getRows().get(0).getSections().get(0).getSeats().size());
		Assert.assertEquals(12, theatre.getTotalEmptySeats());
	}

	/**
	 * Test for - Number of rows, Number of sections, Number of seats, Total Empty Seats
	 */
	@Test
	public void test2() {
		final Theatre theatre = new Theatre();
		LayoutProcessor processor = new LayoutProcessor(theatre);
		processor.process("6 6");
		processor.process("2");
		
		Assert.assertEquals(2, theatre.getRows().size());
		Assert.assertEquals(1, theatre.getRows().get(1).getSections().size());
		Assert.assertEquals(2, theatre.getRows().get(1).getSections().get(0).getSeats().size());
		Assert.assertEquals(14, theatre.getTotalEmptySeats());
	}
}
