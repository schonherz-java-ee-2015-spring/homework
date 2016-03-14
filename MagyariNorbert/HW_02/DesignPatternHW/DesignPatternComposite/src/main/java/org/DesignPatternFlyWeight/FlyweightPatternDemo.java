package org.DesignPatternFlyWeight;

/**
 * Hello world!
 *
 */
public class FlyweightPatternDemo {
	private static final String manufacturers[] = { "HTC", "Samsung", "Apple", "Lenovo", "Motorola" };
	private static final double osVersions[] = { 1.0, 1.1, 1.5, 1.6, 2.1, 2.2, 2.3, 3.0, 4.0, 4.1, 4.4, 5.1, 6.0 };
	private static final double screenSize[] = { 3.0, 3.5, 4.0, 4.3, 4.5, 4.7, 4.9, 5.0, 5.1, 5.2, 5.5, 5.8 };

	public static void main(String[] args) {

		for (int i = 0; i < 10; ++i) {
			SmartPhone smartPhone = (SmartPhone) SmartPhoneFactory.getSmartPhone(getRandomManufacturer());
			smartPhone.setScreenSize(getRandomSize());
			smartPhone.setOsVersion(getRandomOS());
			smartPhone.setCameraMpx(13.0);
			smartPhone.writeFeatures();
		}
	}

	private static String getRandomManufacturer() {
		return manufacturers[(int) (Math.random() * manufacturers.length)];
	}

	private static double getRandomOS() {
		return osVersions[(int) (Math.random() * osVersions.length)];
	}

	private static double getRandomSize() {
		return screenSize[(int) (Math.random() * screenSize.length)];
	}

}
