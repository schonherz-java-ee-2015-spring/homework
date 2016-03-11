package hu.schonherz.java.training.hw.bridge.machine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoffeeMakerTest {
	private static MachineAPI m;

	@Test
	public void testCMakerSwitchOn() {
		m = new CoffeeMaker();
		String result = m.switchOn();
		String expected = CoffeeMaker.COFFEE_MAKER_ON;
		assertEquals(expected, result);
	}

	@Test
	public void testCMakerSwitchOff() {
		m = new CoffeeMaker();
		String result = m.switchOff();
		String expected = CoffeeMaker.COFFEE_MAKER_OFF;
		assertEquals(expected, result);
	}

}
