/**
 * 
 */
package org.DesignPatternBuilder;


/**
 * @author magya
 *
 */
public class DeviceBuilder {

	public Device chooseMobileDevices() {
		Device devices = new Device();
		devices.addItem(new SmartPhone());
		devices.addItem(new Notebook());
		return devices;
	}

	public Device chooseStoneAgeDevices() {
		Device devices = new Device();
		devices.addItem(new CellPhone());
		devices.addItem(new PersonalComputer());
		return devices;
	}
}
