package org.DesignPatternFlyWeight;


import static org.junit.Assert.assertEquals;

import org.DesignPatternFlyWeight.SmartPhone;
import org.DesignPatternFlyWeight.SmartPhoneFactory;
import org.junit.Test;


public class TestClass {
	
	@Test
	public void Test() {
		SmartPhone smartPhone = (SmartPhone) SmartPhoneFactory.getSmartPhone("HTC");
		smartPhone.setCameraMpx(13);
		float expected = (float) smartPhone.getCameraMpx();
		assertEquals(expected, 13.0f, 0.0f);
	}
}
