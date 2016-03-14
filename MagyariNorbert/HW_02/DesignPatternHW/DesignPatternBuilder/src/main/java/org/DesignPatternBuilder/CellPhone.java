/**
 * 
 */
package org.DesignPatternBuilder;

/**
 * @author magya
 *
 */
public class CellPhone extends Phone {

	@Override
	public float price() {
		return 5.5f;
	}

	public String name() {
		return "CellPhone";
	}

}
