package hu.schonherz.java.training.hw.bridge;

import hu.schonherz.java.training.hw.bridge.machine.MachineAPI;

/**
 * Abstract class which use the MachineAPI.
 * 
 * @author Ölveti József
 *
 */
public abstract class Switch {
	protected MachineAPI machineAPI;

	protected Switch(MachineAPI machineAPI) {
		this.machineAPI = machineAPI;
	}

	public abstract String switchOn();

	public abstract String switchOff();
}
