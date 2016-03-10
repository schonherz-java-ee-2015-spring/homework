package hu.schonherz.java.training.hw.bridge.machine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.bridge.machine.CoffeeMaker;
import hu.schonherz.java.training.hw.bridge.machine.Hairdryer;
import hu.schonherz.java.training.hw.bridge.machine.Television;

public class MachineTest {
	private static MachineAPI m;

	@Test
	public void testTvSwitchOn() {
		m = new Television();
		String result = m.switchOn();
		String expected = Television.TV_ON;
		assertEquals(expected, result);
	}

	@Test
	public void testTvSwitchOff() {
		m = new Television();
		String result = m.switchOff();
		String expected = Television.TV_OFF;
		assertEquals(expected, result);
	}

	@Test
	public void testDryerSwitchOn() {
		m = new Hairdryer();
		String result = m.switchOn();
		String expected = Hairdryer.HAIRDRYER_ON;
		assertEquals(expected, result);
	}

	@Test
	public void testDryerSwitchOff() {
		m = new Hairdryer();
		String result = m.switchOff();
		String expected = Hairdryer.HAIRDRYER_OFF;
		assertEquals(expected, result);
	}

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
