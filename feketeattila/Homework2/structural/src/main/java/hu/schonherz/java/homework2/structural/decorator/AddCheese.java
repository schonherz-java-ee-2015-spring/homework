package hu.schonherz.java.homework2.structural.decorator;

import java.util.List;

import hu.schonherz.java.homework2.structural.sandwich.Sandwich;

/**
 * @author Atka
 *
 */
public class AddCheese extends SandwichDecorator {

	public AddCheese(Sandwich sandwich) {
		super(sandwich);
	}

	/* (non-Javadoc)
	 * @see hu.schonherz.java.homework2.structural.decorator.SandwichDecorator#getIngredients()
	 */
	@Override
	public List<String> getIngredients() {
		List<String> ingredients = super.getIngredients();
		ingredients.add("Cheese");
		return ingredients;
	}

	/* (non-Javadoc)
	 * @see hu.schonherz.java.homework2.structural.decorator.SandwichDecorator#getCost()
	 */
	@Override
	public int getCost() {
		return super.getCost() + 75;
	}

}
