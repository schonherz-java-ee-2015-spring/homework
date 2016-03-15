package org.DesignPatternFlyWeight;

public class SmartPhone implements Device {

	private String manufacturer;
	private double screenSize;
	private double osVersion;
	private double cameraMpx;

	public SmartPhone(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void writeFeatures() {
		System.out.println("SmartPhone:[manufacturer : " + manufacturer + ", screenSize : "
				+ screenSize + ", osVersion :" + osVersion + ", cameraMpx :" + cameraMpx + "]");

	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public void setOsVersion(double osVersion) {
		this.osVersion = osVersion;
	}

	public void setCameraMpx(double cameraMpx) {
		this.cameraMpx = cameraMpx;
	}

	public double getCameraMpx() {
		return cameraMpx;
	}


}
