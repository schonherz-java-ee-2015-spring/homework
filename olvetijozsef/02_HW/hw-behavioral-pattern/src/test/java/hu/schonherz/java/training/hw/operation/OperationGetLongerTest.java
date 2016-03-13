package hu.schonherz.java.training.hw.operation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.strategy.Strategy;
import hu.schonherz.java.training.hw.strategy.operation.OperationGetLonger;

public class OperationGetLongerTest {
	private static Strategy ol = new OperationGetLonger();

	@Test
	public void testOperationLonger() {
		String result = ol.doOperation("0", "1");
		String expected = "Same Length";
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLongerFirstL() {
		String result = ol.doOperation("00", "1");
		String expected = "00";
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLongerSecondL() {
		String result = ol.doOperation("00", "111");
		String expected = "111";
		assertEquals(expected, result);
	}

}
