package hu.schonherz.java.homework2.structural.decorator;

import java.util.List;

import hu.schonherz.java.homework2.structural.sandwich.Sandwich;

/**
 * @author Atka
 *
 */
public abstract class SandwichDecorator implements Sandwich {
	protected final Sandwich sandwich;

	public SandwichDecorator(Sandwich sandwich) {
		this.sandwich = sandwich;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.schonherz.java.homework2.structural.sandwich.Sandwich#getIngredients()
	 */
	public List<String> getIngredients() {
		return sandwich.getIngredients();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.schonherz.java.homework2.structural.sandwich.Sandwich#getCost()
	 */
	public int getCost() {
		return sandwich.getCost();
	}

}
