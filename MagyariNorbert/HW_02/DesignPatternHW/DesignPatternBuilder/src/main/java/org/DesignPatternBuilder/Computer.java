/**
 * 
 */
package org.DesignPatternBuilder;


/**
 * @author magya
 *
 */
public abstract class Computer implements Item {

	/* (non-Javadoc)
	 * @see hu.schonherz.training.homework.Item#packing()
	 */
	public Packing packing() {
		return new PackingComputer();
	}

	/* (non-Javadoc)
	 * @see hu.schonherz.training.homework.Item#price()
	 */
	public abstract float price();

}
