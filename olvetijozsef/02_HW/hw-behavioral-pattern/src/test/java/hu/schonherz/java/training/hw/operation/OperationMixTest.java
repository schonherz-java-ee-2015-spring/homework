package hu.schonherz.java.training.hw.operation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.strategy.Strategy;
import hu.schonherz.java.training.hw.strategy.operation.OperationMix;

public class OperationMixTest {
	private static Strategy om = new OperationMix();

	@Test
	public void testOperationMix() {
		String result = om.doOperation("00", "11");
		String expected = "0101";
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMixFirst() {
		String result = om.doOperation("0000", "11");
		String expected = "010100";
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMixSecond() {
		String result = om.doOperation("00", "1111");
		String expected = "010111";
		assertEquals(expected, result);
	}

}
