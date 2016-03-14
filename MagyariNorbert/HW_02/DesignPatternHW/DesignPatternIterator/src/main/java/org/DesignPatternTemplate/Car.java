package org.DesignPatternTemplate;

public class Car extends Manufacturing {

	@Override
	void prepareParts() {
		System.out.println("The metal takes shape.");
	}

	@Override
	void assembly() {
		System.out.println("Assembling the car.");
	}

	@Override
	void sell() {
		System.out.println("Get to the Choppa'!");
	}

}
