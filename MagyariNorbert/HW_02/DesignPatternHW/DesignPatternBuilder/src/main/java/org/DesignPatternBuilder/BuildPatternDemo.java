/**
 * 
 */
package org.DesignPatternBuilder;

/**
 * @author magya
 *
 */
public class BuildPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeviceBuilder deviceBuilder = new DeviceBuilder();

	      Device mobileDevices = deviceBuilder.chooseMobileDevices();
	      System.out.println("Mobile devices");
	      mobileDevices.showItems();
	      System.out.println("Total Cost: " + mobileDevices.getCost());

	      Device stoneAgeDevices = deviceBuilder.chooseStoneAgeDevices();
	      System.out.println("\n\nStone Age Devices");
	      stoneAgeDevices.showItems();
	      System.out.println("Total Cost: " + stoneAgeDevices.getCost());
	   
	}

}
