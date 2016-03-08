package hu.schonherz.java.training.hw.bridge.machine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.bridge.machine.CoffeeMaker;
import hu.schonherz.java.training.hw.bridge.machine.Hairdryer;
import hu.schonherz.java.training.hw.bridge.machine.Television;

public class MachineTest {

	@Test
	public void testTvSwitchOn() {
		MachineAPI m = new Television();
		String result = m.switchOn();
		String expected = "TV Switched on!";
		assertEquals(expected, result);
	}

	@Test
	public void testTvSwitchOff() {
		MachineAPI m = new Television();
		String result = m.switchOff();
		String expected = "TV Switched off!";
		assertEquals(expected, result);
	}

	@Test
	public void testDryerSwitchOn() {
		MachineAPI m = new Hairdryer();
		String result = m.switchOn();
		String expected = "Hairdryer Switched on!";
		assertEquals(expected, result);
	}

	@Test
	public void testDryerSwitchOff() {
		MachineAPI m = new Hairdryer();
		String result = m.switchOff();
		String expected = "Hairdryer Switched off!";
		assertEquals(expected, result);
	}

	@Test
	public void testCMakerSwitchOn() {
		MachineAPI m = new CoffeeMaker();
		String result = m.switchOn();
		String expected = "Coffee Maker Switched on!";
		assertEquals(expected, result);
	}

	@Test
	public void testCMakerSwitchOff() {
		MachineAPI m = new CoffeeMaker();
		String result = m.switchOff();
		String expected = "Coffee Maker Switched off!";
		assertEquals(expected, result);
	}

}
