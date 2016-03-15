package hu.schonherz.java.homework2.structural.main;

import hu.schonherz.java.homework2.structural.decorator.AddCheese;
import hu.schonherz.java.homework2.structural.decorator.AddHam;
import hu.schonherz.java.homework2.structural.decorator.AddMayonnaise;
import hu.schonherz.java.homework2.structural.sandwich.BasicSandwich;
import hu.schonherz.java.homework2.structural.sandwich.Sandwich;

/**
 * @author Atka
 *
 */
public class DecoratorMain {

	/**
	 * Writes out the ingredients and cost of a sandwich
	 * 
	 * @param sandwich
	 *            The sandwich we want to know more about
	 */
	public static void sandwichInfo(Sandwich sandwich) {
		System.out.println("Current sandwich ingredients:");
		for (String ingredient : sandwich.getIngredients()) {
			System.out.println(" -" + ingredient);
		}
		System.out.println("Cost: " + sandwich.getCost());
	}

	public static void main(String[] args) {
		Sandwich sandwich = new BasicSandwich();
		// Our sandwich is only made of a slice of bread
		sandwichInfo(sandwich);
		sandwich = new AddMayonnaise(sandwich);
		sandwich = new AddHam(sandwich);
		sandwich = new AddCheese(sandwich);
		// Our sandwich has more ingredients now
		sandwichInfo(sandwich);
	}

}
