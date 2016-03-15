/**
 * 
 */
package org.DesignPatternBuilder;

/**
 * @author magya
 *
 */
public abstract class Phone implements Item {


	/* (non-Javadoc)
	 * @see hu.schonherz.training.homework.Item#packing()
	 */
	public Packing packing() {
		return new PackingPhone();
	}

	/* (non-Javadoc)
	 * @see hu.schonherz.training.homework.Item#price()
	 */
	public abstract float price();

}
