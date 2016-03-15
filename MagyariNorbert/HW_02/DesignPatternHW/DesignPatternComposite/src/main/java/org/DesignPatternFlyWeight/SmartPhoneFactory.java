package org.DesignPatternFlyWeight;

import java.util.HashMap;

public class SmartPhoneFactory {
	private static final HashMap<String, Device> smartPhoneMap = new HashMap();

	public static Device getSmartPhone(String manufacturer) {
		SmartPhone smartphone = (SmartPhone) smartPhoneMap.get(manufacturer);

		if (smartphone == null) {
			smartphone = new SmartPhone(manufacturer);
			smartPhoneMap.put(manufacturer, smartphone);
			System.out.println("Creating smartphone of manufacturer : " + manufacturer);
		}
		return smartphone;
	}
}
