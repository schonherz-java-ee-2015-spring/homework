package hu.schonherz.java.training.hw.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.strategy.operation.OperationConcat;
import hu.schonherz.java.training.hw.strategy.operation.OperationGetLonger;
import hu.schonherz.java.training.hw.strategy.operation.OperationMix;

public class ContextTest {

	@Test
	public void testOperationConcat() {
		OperationConcat oc = new OperationConcat();
		Context ctx = new Context(oc);
		String expected = "01";
		String result = ctx.executeStrategy("0", "1");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLonger() {
		OperationGetLonger ol = new OperationGetLonger();
		Context ctx = new Context(ol);
		String expected = "Same Length";
		String result = ctx.executeStrategy("0", "1");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLongerFirstL() {
		OperationGetLonger ol = new OperationGetLonger();
		Context ctx = new Context(ol);
		String expected = "00";
		String result = ctx.executeStrategy("00", "1");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationLongerSecondL() {
		OperationGetLonger ol = new OperationGetLonger();
		Context ctx = new Context(ol);
		String expected = "111";
		String result = ctx.executeStrategy("00", "111");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMix() {
		OperationMix om = new OperationMix();
		Context ctx = new Context(om);
		String expected = "0101";
		String result = ctx.executeStrategy("00", "11");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMixFirst() {
		OperationMix om = new OperationMix();
		Context ctx = new Context(om);
		String expected = "010100";
		String result = ctx.executeStrategy("0000", "11");
		assertEquals(expected, result);
	}

	@Test
	public void testOperationMixSecond() {
		OperationMix om = new OperationMix();
		Context ctx = new Context(om);
		String expected = "010111";
		String result = ctx.executeStrategy("00", "1111");
		assertEquals(expected, result);
	}

}
