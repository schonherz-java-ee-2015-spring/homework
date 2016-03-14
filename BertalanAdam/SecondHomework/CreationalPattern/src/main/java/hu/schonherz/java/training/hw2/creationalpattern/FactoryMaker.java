package hu.schonherz.java.training.hw2.creationalpattern;

/**
 * Class for giving Factories back.
 * */
public class FactoryMaker {
	
	private static AbstractFactory af = null;

	/**
	 * Returns the Factory indicated with the given type.
	 * @param The desired type as a char. If it is '1' then
	 * {@link PenAndPencilFactory1} will be given back, 
	 * else {@link PenAndPencilFactory2} will be given back.
	 * @return The chosen {@link AbstractFactory}.
	 * */
	public static AbstractFactory getFactory(char which) {
		if (which == '1') {
			af = new PenAndPencilFactory1();
		} else {
			af = new PenAndPencilFactory2();
		}
		return af;
	}
}
