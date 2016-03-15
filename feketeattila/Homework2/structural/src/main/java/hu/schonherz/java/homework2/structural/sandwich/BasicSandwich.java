package hu.schonherz.java.homework2.structural.sandwich;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Atka
 *
 */
public class BasicSandwich implements Sandwich {

	/* (non-Javadoc)
	 * @see hu.schonherz.java.homework2.structural.sandwich.Sandwich#getIngredients()
	 */
	public List<String> getIngredients() {
		List<String> result = new ArrayList<String>();
		result.add("Slice of bread");
		return result;
	}

	/* (non-Javadoc)
	 * @see hu.schonherz.java.homework2.structural.sandwich.Sandwich#getCost()
	 */
	public int getCost() {
		return 50;
	}

}
