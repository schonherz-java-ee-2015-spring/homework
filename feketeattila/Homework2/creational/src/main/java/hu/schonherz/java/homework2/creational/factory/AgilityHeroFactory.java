package hu.schonherz.java.homework2.creational.factory;

import hu.schonherz.java.homework2.creational.product.AgilityHero;
import hu.schonherz.java.homework2.creational.product.Hero;

/**
 * @author Atka
 *
 */
public class AgilityHeroFactory implements AbstractHeroFactory {

	public Hero createHero(String name) {
		return new AgilityHero(name);
	}

}
