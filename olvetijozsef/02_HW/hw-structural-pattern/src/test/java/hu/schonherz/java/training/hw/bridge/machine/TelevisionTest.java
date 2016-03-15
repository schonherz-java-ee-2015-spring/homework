package hu.schonherz.java.training.hw.bridge.machine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TelevisionTest {
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

}
