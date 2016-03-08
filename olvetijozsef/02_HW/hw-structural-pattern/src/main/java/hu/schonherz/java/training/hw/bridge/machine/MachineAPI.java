package hu.schonherz.java.training.hw.bridge.machine;

/**
 * Interface for machine functions.
 * 
 * @author Ölveti József
 *
 */
public interface MachineAPI {
	/**
	 * Switch on the machine. Returns with a status String.
	 * 
	 * @return the status String
	 */
	String switchOn();

	/**
	 * Switch off the machine. Returns with a status String.
	 * 
	 * @return the status String
	 */
	String switchOff();

}
