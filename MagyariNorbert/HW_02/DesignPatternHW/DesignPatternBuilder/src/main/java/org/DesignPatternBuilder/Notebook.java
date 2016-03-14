/**
 * 
 */
package org.DesignPatternBuilder;

/**
 * @author magya
 *
 */
public class Notebook extends Computer {

	@Override
	public float price() {
		return 35.0f;
	}

	public String name() {
		return "Notebook";
	}

}
