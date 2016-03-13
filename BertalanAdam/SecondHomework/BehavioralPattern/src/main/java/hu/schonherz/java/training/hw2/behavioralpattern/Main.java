package hu.schonherz.java.training.hw2.behavioralpattern;

// Template method Behavioral Pattern
public class Main {

	public static void main(String[] args) {
		DoDinner dd = new HaveSpaghetti();
		dd.cookMeal();
		
		dd = new HaveLasagne();
		dd.cookMeal();
	}

}
