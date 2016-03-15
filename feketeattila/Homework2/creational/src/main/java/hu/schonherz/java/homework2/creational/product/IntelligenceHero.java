package hu.schonherz.java.homework2.creational.product;

/**
 * @author Atka
 *
 */
public class IntelligenceHero implements Hero {
	/**
	 * Name of the hero
	 */
	private String name;

	public IntelligenceHero(String name) {
		super();
		this.name = name;
	}

	public String welcomeText() {
		return "My name is " + this.name + ", and I'm an Intelligence hero.";
	}
}
