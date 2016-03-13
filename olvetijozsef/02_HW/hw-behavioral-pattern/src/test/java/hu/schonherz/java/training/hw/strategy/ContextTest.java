package hu.schonherz.java.training.hw.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.strategy.operation.OperationConcat;
import hu.schonherz.java.training.hw.strategy.operation.OperationGetLonger;
import hu.schonherz.java.training.hw.strategy.operation.OperationMix;

public class ContextTest {
	private static Context ctx;

	@Test
	public void testOperationConcat() {
		ctx = new Context(new OperationConcat());
		String result = ctx.executeStrategy("0", "1");
		String expected = "01";
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLonger() {
		ctx = new Context(new OperationGetLonger());
		String result = ctx.executeStrategy("0", "1");
		String expected = "Same Length";
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLongerFirstL() {
		ctx = new Context(new OperationGetLonger());
		String result = ctx.executeStrategy("00", "1");
		String expected = "00";
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLongerSecondL() {
		ctx = new Context(new OperationGetLonger());
		String result = ctx.executeStrategy("00", "111");
		String expected = "111";
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMix() {
		ctx = new Context(new OperationMix());
		String result = ctx.executeStrategy("00", "11");
		String expected = "0101";
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMixFirst() {
		ctx = new Context(new OperationMix());
		String result = ctx.executeStrategy("0000", "11");
		String expected = "010100";
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMixSecond() {
		ctx = new Context(new OperationMix());
		String result = ctx.executeStrategy("00", "1111");
		String expected = "010111";
		assertEquals(expected, result);
	}

}
