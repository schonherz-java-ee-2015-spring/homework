/**
 * 
 */
package org.DesignPatternBuilder;

/**
 * @author magya
 *
 */
public class PersonalComputer extends Computer {

	@Override
	public float price() {
		return 30.0f;
	}

	public String name() {
		return "Personal Computer";
	}

}
