package org.DesignPatternBuilder;

import org.junit.Test;

import static org.junit.Assert.*;

public class StoneAgeTest {

	@Test
	public void testStoneAgeDevicesCost() {
		DeviceBuilder deviceBuilder = new DeviceBuilder();
		Device devices = deviceBuilder.chooseStoneAgeDevices();
		float expected = devices.getCost();
		assertEquals(expected,  35.5f, 0.0f);
		
	}

}
