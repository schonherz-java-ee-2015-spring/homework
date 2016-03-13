package hu.schonherz.java.training.hw.bridge.machine;

/**
 * Implements the coffee maker machine.
 * 
 * @author Ölveti József
 *
 */
public class CoffeeMaker implements MachineAPI {

	public static final String COFFEE_MAKER_OFF = "Coffee Maker Switched off!";
	public static final String COFFEE_MAKER_ON = "Coffee Maker Switched on!";

	@Override
	public String switchOn() {
		return COFFEE_MAKER_ON;
	}

	@Override
	public String switchOff() {
		return COFFEE_MAKER_OFF;
	}

}
