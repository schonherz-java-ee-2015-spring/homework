package hu.schonherz.java.training.hw.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.strategy.operation.OperationConcat;
import hu.schonherz.java.training.hw.strategy.operation.OperationGetLonger;
import hu.schonherz.java.training.hw.strategy.operation.OperationMix;

public class ContextTest {

	@Test
	public void testOperationConcat() {
		Context ctx = new Context(new OperationConcat());
		String expected = "01";
		String result = ctx.executeStrategy("0", "1");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLonger() {
		Context ctx = new Context(new OperationGetLonger());
		String expected = "Same Length";
		String result = ctx.executeStrategy("0", "1");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLongerFirstL() {
		Context ctx = new Context(new OperationGetLonger());
		String expected = "00";
		String result = ctx.executeStrategy("00", "1");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLongerSecondL() {
		Context ctx = new Context(new OperationGetLonger());
		String expected = "111";
		String result = ctx.executeStrategy("00", "111");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMix() {
		Context ctx = new Context(new OperationMix());
		String expected = "0101";
		String result = ctx.executeStrategy("00", "11");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMixFirst() {
		Context ctx = new Context(new OperationMix());
		String expected = "010100";
		String result = ctx.executeStrategy("0000", "11");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMixSecond() {
		Context ctx = new Context(new OperationMix());
		String expected = "010111";
		String result = ctx.executeStrategy("00", "1111");
		assertEquals(expected, result);
	}

}
