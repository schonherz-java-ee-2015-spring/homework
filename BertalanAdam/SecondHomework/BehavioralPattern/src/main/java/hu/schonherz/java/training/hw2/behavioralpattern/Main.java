package hu.schonherz.java.training.hw2.behavioralpattern;

/**
 * Template method Behavioral Pattern.
 * The purpose of this pattern is that it defines a final method,
 * which defines a way to use the other methods in a class.
 * In this way, you only have to modify the methods that contain logic, and
 * the only thing remains is to call the final method to do the appropriate functionality.
 * */
public class Main {

	/**
	 * The program's enter point.
	 * */
	public static void main(String[] args) {
		DoDinner dd = new HaveSpaghetti();
		dd.cookMeal();
		
		dd = new HaveLasagne();
		dd.cookMeal();
	}

}
