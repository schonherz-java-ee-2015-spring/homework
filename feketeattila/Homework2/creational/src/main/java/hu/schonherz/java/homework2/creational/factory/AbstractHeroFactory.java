package hu.schonherz.java.homework2.creational.factory;

import hu.schonherz.java.homework2.creational.product.Hero;

/**
 * @author Atka
 *
 */
public interface AbstractHeroFactory {
	/**
	 * @param name Name of the hero
	 * @return The created hero
	 */
	public Hero createHero(String name);
}
