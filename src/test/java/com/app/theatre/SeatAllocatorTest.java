package com.app.theatre;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class SeatAllocatorTest {

	/**
	 * Normal flow.
	 */
	@Test
	public void test1() {
		final Theatre theatre = new Theatre();
		LayoutProcessor layoutProcessor = new LayoutProcessor(theatre);
		layoutProcessor.process("6 6");
		
		RequestProcessor requestProcessor = new RequestProcessor();
		requestProcessor.process("Smith 2");
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
        
		SeatAllocator allocator = new SeatAllocator(theatre, requestProcessor.getRequests());
		allocator.process();
		Assert.assertEquals("Smith Row 1 Section 1\n", outContent.toString());
	}
	
	/**
	 * Call to split party.
	 */
	@Test
	public void test2() {
		final Theatre theatre = new Theatre();
		LayoutProcessor layoutProcessor = new LayoutProcessor(theatre);
		layoutProcessor.process("4 6");
		layoutProcessor.process("2 2");
		
		RequestProcessor requestProcessor = new RequestProcessor();
		requestProcessor.process("Smith 12");
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
        
		SeatAllocator allocator = new SeatAllocator(theatre, requestProcessor.getRequests());
		allocator.process();
		Assert.assertEquals("Smith "+Constants.CALL_TO_SPLIT+ "\n", outContent.toString());
	}
	
	/**
	 * Sorry, we can't handle your party.
	 */
	@Test
	public void test3() {
		final Theatre theatre = new Theatre();
		LayoutProcessor layoutProcessor = new LayoutProcessor(theatre);
		layoutProcessor.process("6 6");
		
		RequestProcessor requestProcessor = new RequestProcessor();
		requestProcessor.process("Smith 22");
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
        
		SeatAllocator allocator = new SeatAllocator(theatre, requestProcessor.getRequests());
		allocator.process();
		Assert.assertEquals("Smith "+Constants.SORRY_CANNOT_HANDLE+ "\n", outContent.toString());
	}

}
