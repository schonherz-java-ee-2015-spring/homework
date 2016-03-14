package hu.schonherz.java.training.hw2.behavioralpattern;

/**
 * A class that contains methods to create a meal.
 * */
public abstract class DoDinner {

	/**
	 * Describes how to gather ingredients.
	 * */
	abstract void gatherIngredients();
	
	/**
	 * Describes how to cook a meal.
	 * */
	abstract void cookMeal();
	
	/**
	 * Describes how to eat.
	 * */
	abstract void eat();
	
	/**
	 * Describes how to wash up.
	 */
	abstract void washUp();
	
	/**
	 * Final Template method that walk through the steps of creating a meal
	 * in the correct order.
	 * */
	public final void haveDinner(){
		gatherIngredients();
		cookMeal();
		eat();
		washUp();
	}
}
