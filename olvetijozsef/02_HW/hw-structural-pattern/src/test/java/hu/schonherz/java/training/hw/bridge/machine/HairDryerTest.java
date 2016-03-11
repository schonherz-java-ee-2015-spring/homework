package hu.schonherz.java.training.hw.bridge.machine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HairDryerTest {
	private static MachineAPI m;

	@Test
	public void testDryerSwitchOn() {
		m = new HairDryer();
		String result = m.switchOn();
		String expected = HairDryer.HAIRDRYER_ON;
		assertEquals(expected, result);
	}

	@Test
	public void testDryerSwitchOff() {
		m = new HairDryer();
		String result = m.switchOff();
		String expected = HairDryer.HAIRDRYER_OFF;
		assertEquals(expected, result);
	}

}
