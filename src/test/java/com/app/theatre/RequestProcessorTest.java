package com.app.theatre;

import org.junit.Assert;
import org.junit.Test;

import com.app.exception.InvalidTicketRequestException;

public class RequestProcessorTest {

	/**
	 * Test for Request Size, Name, Tickets
	 */
	@Test
	public void test1() {
		RequestProcessor processor = new RequestProcessor();
		processor.process("Smith 2");
		Assert.assertEquals(1, processor.getRequests().size());
		Assert.assertEquals("Smith", processor.getRequests().get(0).getName());
		Assert.assertEquals(2, processor.getRequests().get(0).getNumTicketsRequested());
	}

	/**
	 * Expect InvalidTicketRequestException
	 */
	@Test(expected = InvalidTicketRequestException.class)
	public void test2() {
		RequestProcessor processor = new RequestProcessor();
		processor.process("Smith");
	}

}
