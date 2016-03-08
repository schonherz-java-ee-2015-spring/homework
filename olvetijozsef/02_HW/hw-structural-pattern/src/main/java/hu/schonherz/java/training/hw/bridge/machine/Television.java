package hu.schonherz.java.training.hw.bridge.machine;

/**
 * Implements a television machine.
 * 
 * @author Ölveti József
 *
 */
public class Television implements MachineAPI {

	@Override
	public String switchOn() {
		return "TV Switched on!";
	}

	@Override
	public String switchOff() {
		return "TV Switched off!";
	}

}
