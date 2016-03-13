package hu.schonherz.java.training.hw.bridge.machine;

/**
 * Implements the television machine.
 * 
 * @author Ölveti József
 *
 */
public class Television implements MachineAPI {

	public static final String TV_OFF = "TV Switched off!";
	public static final String TV_ON = "TV Switched on!";

	@Override
	public String switchOn() {
		return TV_ON;
	}

	@Override
	public String switchOff() {
		return TV_OFF;
	}

}
