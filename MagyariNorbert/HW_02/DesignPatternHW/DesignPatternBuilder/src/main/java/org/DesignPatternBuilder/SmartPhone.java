/**
 * 
 */
package org.DesignPatternBuilder;

/**
 * @author magya
 *
 */
public class SmartPhone extends Phone {

	@Override
	public float price() {
		return 25.0f;
	}

	public String name() {
		return "Smartphone";
	}

}
