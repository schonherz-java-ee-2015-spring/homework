package org.DesignPatternBuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class MobileTest {
	
	@Test
	public void testMobileDevicesCost() {
		DeviceBuilder deviceBuilder = new DeviceBuilder();
		Device devices = deviceBuilder.chooseMobileDevices();
		float expected = devices.getCost();
		assertEquals(expected, 60.0f, 0.0f);

	}
}
