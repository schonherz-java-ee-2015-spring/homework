package hu.schonherz.java.training.hw.operation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.strategy.operation.OperationGetLonger;

public class OperationGetLongerTest {

	@Test
	public void testOperationLonger() {
		OperationGetLonger ol = new OperationGetLonger();
		String expected = "Same Length";
		String result = ol.doOperation("0", "1");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLongerFirstL() {
		OperationGetLonger ol = new OperationGetLonger();
		String expected = "00";
		String result = ol.doOperation("00", "1");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLongerSecondL() {
		OperationGetLonger ol = new OperationGetLonger();
		String expected = "111";
		String result = ol.doOperation("00", "111");
		assertEquals(expected, result);
	}

}
