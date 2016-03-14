package org.DesignPatternTemplate;

import static org.junit.Assert.assertNotSame;

import org.DesignPatternTemplate.Car;
import org.DesignPatternTemplate.SmartPhone;
import org.junit.Test;

public class SmartPhoneTest {
	@Test
	public void testAssertNotSame() {
		assertNotSame("should not be same Object", new SmartPhone(), new Car());
	}
}
