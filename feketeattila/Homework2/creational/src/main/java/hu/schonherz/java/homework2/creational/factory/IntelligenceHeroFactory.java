package hu.schonherz.java.homework2.creational.factory;

import hu.schonherz.java.homework2.creational.product.Hero;
import hu.schonherz.java.homework2.creational.product.IntelligenceHero;

/**
 * @author Atka
 *
 */
public class IntelligenceHeroFactory implements AbstractHeroFactory {

	public Hero createHero(String name) {
		return new IntelligenceHero(name);
	}

}
