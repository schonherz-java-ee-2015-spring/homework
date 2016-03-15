package hu.schonherz.java.training.hw.strategy;

/**
 * Class which use a Strategy object.
 * 
 * @author Ölveti József
 *
 */
public class Context {
	/**
	 * The Strategy object for the manipulation.
	 */
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Returns with the operation result String.
	 * 
	 * @param str1
	 *            first input String
	 * @param str2
	 *            second input String
	 * @return result String
	 */
	public String executeStrategy(String str1, String str2) {
		return strategy.doOperation(str1, str2);
	}
}