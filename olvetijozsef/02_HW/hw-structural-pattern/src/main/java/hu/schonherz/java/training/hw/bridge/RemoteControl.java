package hu.schonherz.java.training.hw.bridge;

import hu.schonherz.java.training.hw.bridge.machine.MachineAPI;

/**
 * Implements the remote control.
 * 
 * @author Ölveti József
 *
 */
public class RemoteControl extends Switch {

	public RemoteControl(MachineAPI machineAPI) {
		super(machineAPI);
	}

	@Override
	public String switchOn() {
		return machineAPI.switchOn();
	}

	@Override
	public String switchOff() {
		return machineAPI.switchOff();
	}

}
