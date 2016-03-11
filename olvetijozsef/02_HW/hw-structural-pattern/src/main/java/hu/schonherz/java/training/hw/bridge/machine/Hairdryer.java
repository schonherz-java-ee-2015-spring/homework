package hu.schonherz.java.training.hw.bridge.machine;

/**
 * Implements the hairdryer machine.
 * 
 * @author Ölveti József
 *
 */
public class HairDryer implements MachineAPI {

	public static final String HAIRDRYER_OFF = "Hairdryer Switched off!";
	public static final String HAIRDRYER_ON = "Hairdryer Switched on!";

	@Override
	public String switchOn() {
		return HAIRDRYER_ON;
	}

	@Override
	public String switchOff() {
		return HAIRDRYER_OFF;
	}

}
