package hu.schonherz.java.training.hw.operation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.strategy.operation.OperationMix;

public class OperationMixTest {

	@Test
	public void testOperationMix() {
		OperationMix om = new OperationMix();
		String expected = "0101";
		String result = om.doOperation("00", "11");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMixFirst() {
		OperationMix om = new OperationMix();
		String expected = "010100";
		String result = om.doOperation("0000", "11");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMixSecond() {
		OperationMix om = new OperationMix();
		String expected = "010111";
		String result = om.doOperation("00", "1111");
		assertEquals(expected, result);
	}

}
