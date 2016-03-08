package hu.schonherz.java.training.hw.bridge.machine;

/**
 * Implements a hairdryer machine.
 * 
 * @author Ölveti József
 *
 */
public class Hairdryer implements MachineAPI {

	@Override
	public String switchOn() {
		return "Hairdryer Switched on!";
	}

	@Override
	public String switchOff() {
		return "Hairdryer Switched off!";
	}

}
