package hu.schonherz.java.training.hw.operation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.strategy.Strategy;
import hu.schonherz.java.training.hw.strategy.operation.OperationConcat;

public class OperationConcatTest {
	private static Strategy oc = new OperationConcat();

	@Test
	public void testOperationConcat() {
		String result = oc.doOperation("0", "1");
		String expected = "01";
		assertEquals(expected, result);
	}

}
