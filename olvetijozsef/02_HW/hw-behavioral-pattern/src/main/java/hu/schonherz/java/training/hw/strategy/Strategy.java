package hu.schonherz.java.training.hw.strategy;

/**
 * Interface of Strategy.
 * 
 * @author Ölveti József
 *
 */
public interface Strategy {
	/**
	 * The operation method. Manipulate two strings, with each other. Returns
	 * with a manipulated string.
	 * 
	 * @param str1
	 *            first input String
	 * @param str2
	 *            second input String
	 * @return result String
	 */
	String doOperation(String str1, String str2);
}
