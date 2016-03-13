package hu.schonherz.homework.math.operator;

/**
 * Subtraction class that implements MathOperation interface
 * 
 * @author Iványi-Nagy Gábor
 */
public class Subtraction implements MathOperation {

	/**
	 * @return the the difference of the two paramter numbers
	 */
	@Override
	public Integer operator(Integer firstNumber, Integer secondNumber) {
		return firstNumber - secondNumber;
	}

}
