package org.DesignPatternTemplate;

public class SmartPhone extends Manufacturing {

	@Override
	void prepareParts() {
		System.out.println("Ordering parts of the phone");
	}

	@Override
	void assembly() {
		System.out.println("Assembling the phone.");
	}

	@Override
	void sell() {
		System.out.println("Marketing and bullshit.");
	}

}
