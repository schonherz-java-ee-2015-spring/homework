package hu.schonherz.java.homework2.structural.sandwich;

import java.util.List;

/**
 * @author Atka
 *
 */
public interface Sandwich {
	/**
	 * @return A list of the ingredients of this sandwich
	 */
	public List<String> getIngredients();

	/**
	 * @return The cost of this sandwich (Depends on current ingredients)
	 */
	public int getCost();
}
