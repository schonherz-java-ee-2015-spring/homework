package hu.schonherz.java.training.hw.operation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.strategy.operation.OperationConcat;

public class OperationConcatTest {

	@Test
	public void testOperationConcat() {
		OperationConcat oc = new OperationConcat();
		String expected = "01";
		String result = oc.doOperation("0", "1");
		assertEquals(expected, result);
	}

}
