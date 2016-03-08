package hu.schonherz.java.training.hw.bridge.machine;

/**
 * Implements a coffee maker machine.
 * 
 * @author Ölveti József
 *
 */
public class CoffeeMaker implements MachineAPI {

	@Override
	public String switchOn() {
		return "Coffee Maker Switched on!";
	}

	@Override
	public String switchOff() {
		return "Coffee Maker Switched off!";
	}

}
