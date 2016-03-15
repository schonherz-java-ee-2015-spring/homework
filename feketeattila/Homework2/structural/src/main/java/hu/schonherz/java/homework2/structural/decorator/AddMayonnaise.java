package hu.schonherz.java.homework2.structural.decorator;

import java.util.List;

import hu.schonherz.java.homework2.structural.sandwich.Sandwich;

/**
 * @author Atka
 *
 */
public class AddMayonnaise extends SandwichDecorator {
	public AddMayonnaise(Sandwich sandwich) {
		super(sandwich);
	}

	/* (non-Javadoc)
	 * @see hu.schonherz.java.homework2.structural.decorator.SandwichDecorator#getIngredients()
	 */
	@Override
	public List<String> getIngredients() {
		List<String> ingredients = super.getIngredients();
		ingredients.add("Mayonnaise");
		return ingredients;
	}

	/* (non-Javadoc)
	 * @see hu.schonherz.java.homework2.structural.decorator.SandwichDecorator#getCost()
	 */
	@Override
	public int getCost() {
		return super.getCost() + 25;
	}

}
