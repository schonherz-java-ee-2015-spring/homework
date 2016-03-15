package hu.schonherz.java.homework2.creational.product;

/**
 * @author Atka
 *
 */
public class StrengthHero implements Hero {
	/**
	 * Name of the hero
	 */
	private String name;

	public StrengthHero(String name) {
		super();
		this.name = name;
	}

	public String welcomeText() {
		return "My name is " + this.name + ", and I'm a Strength hero.";
	}
}