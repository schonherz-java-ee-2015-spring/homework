package hu.schonherz.java.homework2.creational.main;

import hu.schonherz.java.homework2.creational.factory.AbstractHeroFactory;
import hu.schonherz.java.homework2.creational.factory.AgilityHeroFactory;
import hu.schonherz.java.homework2.creational.factory.IntelligenceHeroFactory;
import hu.schonherz.java.homework2.creational.factory.StrengthHeroFactory;
import hu.schonherz.java.homework2.creational.product.Hero;

/**
 * @author Atka
 *
 */
public class AbstractFactoryMain {

	public static void main(String[] args) {
		//Initializing three different factories
		AbstractHeroFactory strengthHeroFactory = new StrengthHeroFactory();
		AbstractHeroFactory agilityHeroFactory = new AgilityHeroFactory();
		AbstractHeroFactory intelligenceHeroFactory = new IntelligenceHeroFactory();

		//Initializing three different heroes, using the factories
		Hero pudge = strengthHeroFactory.createHero("Pudge");
		Hero ursa = agilityHeroFactory.createHero("Ursa");
		Hero invoker = intelligenceHeroFactory.createHero("Invoker");
		
		//Printing out a brief introduction of the new heroes
		System.out.println(pudge.welcomeText());
		System.out.println(ursa.welcomeText());
		System.out.println(invoker.welcomeText());
	}

}
