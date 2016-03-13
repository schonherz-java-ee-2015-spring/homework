package hu.schonherz.java.training.hw2.creationalpattern;

public class FactoryMaker {
	private static AbstractFactory af = null;

	public static AbstractFactory getFactory(char which) {
		if (which == '1') {
			af = new PenAndPencilFactory1();
		} else {
			af = new PenAndPencilFactory2();
		}
		return af;
	}
}
