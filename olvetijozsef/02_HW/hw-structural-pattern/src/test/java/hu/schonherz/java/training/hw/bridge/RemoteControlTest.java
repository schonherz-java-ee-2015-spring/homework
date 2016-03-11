package hu.schonherz.java.training.hw.bridge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.bridge.machine.CoffeeMaker;
import hu.schonherz.java.training.hw.bridge.machine.HairDryer;
import hu.schonherz.java.training.hw.bridge.machine.Television;

public class RemoteControlTest {
	private static RemoteControl rc;

	@Test
	public void testTvSwitchOn() {
		rc = new RemoteControl(new Television());
		String result = rc.switchOn();
		String expected = Television.TV_ON;
		assertEquals(expected, result);
	}

	@Test
	public void testTvSwitchOff() {
		rc = new RemoteControl(new Television());
		String result = rc.switchOff();
		String expected = Television.TV_OFF;
		assertEquals(expected, result);
	}

	@Test
	public void testDryerSwitchOn() {
		rc = new RemoteControl(new HairDryer());
		String result = rc.switchOn();
		String expected = HairDryer.HAIRDRYER_ON;
		assertEquals(expected, result);
	}

	@Test
	public void testDryerSwitchOff() {
		rc = new RemoteControl(new HairDryer());
		String result = rc.switchOff();
		String expected = HairDryer.HAIRDRYER_OFF;
		assertEquals(expected, result);
	}

	@Test
	public void testCMakerSwitchOn() {
		rc = new RemoteControl(new CoffeeMaker());
		String result = rc.switchOn();
		String expected = CoffeeMaker.COFFEE_MAKER_ON;
		assertEquals(expected, result);
	}

	@Test
	public void testCMakerSwitchOff() {
		rc = new RemoteControl(new CoffeeMaker());
		String result = rc.switchOff();
		String expected = CoffeeMaker.COFFEE_MAKER_OFF;
		assertEquals(expected, result);
	}
}
