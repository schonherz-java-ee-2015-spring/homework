package hu.schonherz.homework.math.operator;

/**
 * Addition class that implements MathOperation interface
 * 
 * @author Iványi-Nagy Gábor
 */
public class Addition implements MathOperation {

	/**
	 * @return the sum of the two paramter numbers
	 */
	@Override
	public Integer operator(Integer firstNumber, Integer secondNumber) {
		return firstNumber + secondNumber;
	}

}
