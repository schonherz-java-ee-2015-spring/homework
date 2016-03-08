package hu.schonherz.java.training.hw.bridge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.bridge.machine.CoffeeMaker;
import hu.schonherz.java.training.hw.bridge.machine.Hairdryer;
import hu.schonherz.java.training.hw.bridge.machine.Television;

public class RemoteControlTest {

	@Test
	public void testTvSwitchOn() {
		RemoteControl rc = new RemoteControl(new Television());
		String result = rc.switchOn();
		String expected = "TV Switched on!";
		assertEquals(expected, result);
	}

	@Test
	public void testTvSwitchOff() {
		RemoteControl rc = new RemoteControl(new Television());
		String result = rc.switchOff();
		String expected = "TV Switched off!";
		assertEquals(expected, result);
	}

	@Test
	public void testDryerSwitchOn() {
		RemoteControl rc = new RemoteControl(new Hairdryer());
		String result = rc.switchOn();
		String expected = "Hairdryer Switched on!";
		assertEquals(expected, result);
	}

	@Test
	public void testDryerSwitchOff() {
		RemoteControl rc = new RemoteControl(new Hairdryer());
		String result = rc.switchOff();
		String expected = "Hairdryer Switched off!";
		assertEquals(expected, result);
	}

	@Test
	public void testCMakerSwitchOn() {
		RemoteControl rc = new RemoteControl(new CoffeeMaker());
		String result = rc.switchOn();
		String expected = "Coffee Maker Switched on!";
		assertEquals(expected, result);
	}

	@Test
	public void testCMakerSwitchOff() {
		RemoteControl rc = new RemoteControl(new CoffeeMaker());
		String result = rc.switchOff();
		String expected = "Coffee Maker Switched off!";
		assertEquals(expected, result);
	}

}
