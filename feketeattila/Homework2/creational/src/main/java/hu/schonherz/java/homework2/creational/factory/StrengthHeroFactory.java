package hu.schonherz.java.homework2.creational.factory;

import hu.schonherz.java.homework2.creational.product.Hero;
import hu.schonherz.java.homework2.creational.product.StrengthHero;

/**
 * @author Atka
 *
 */
public class StrengthHeroFactory implements AbstractHeroFactory {

	public Hero createHero(String name) {
		return new StrengthHero(name);
	}

}
