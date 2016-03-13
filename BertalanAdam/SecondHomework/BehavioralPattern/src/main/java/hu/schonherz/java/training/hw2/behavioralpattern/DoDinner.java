package hu.schonherz.java.training.hw2.behavioralpattern;

public abstract class DoDinner {

	abstract void gatherIngredients();
	abstract void cookMeal();
	abstract void eat();
	abstract void washUp();
	
	public final void haveDinner(){
		gatherIngredients();
		cookMeal();
		eat();
		washUp();
	}
}
