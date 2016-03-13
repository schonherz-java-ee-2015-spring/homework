package hu.schonherz.java.training.hw2.behavioralpattern;

public class HaveSpaghetti extends DoDinner {

	private boolean hasEverythingNecessary;
	
	@Override
	void gatherIngredients() {
		if( hasEverythingNecessary )
			System.out.println("Oh fine I do not need to buy anything!");
		else
			System.out.println("Let's go to the shop and buy ingredients!");
	}

	@Override
	void cookMeal() {
		System.out.println("Boiling water and put noodles into... etc.");
	}

	@Override
	void eat() {
		System.out.println("Eating the spaghetti");
	}

	@Override
	void washUp() {
		System.out.println("Cleaning the plates and forks...");
	}

}
