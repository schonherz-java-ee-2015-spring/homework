package hu.schonherz.homework.math.operator;

/**
 * Division class that implements MathOperation interface
 * 
 * @author Iványi-Nagy Gábor
 */
public class Division implements MathOperation {

	/**
	 * @return the quotient of the two parameter numbers
	 */
	@Override
	public Integer operator(Integer firstNumber, Integer secondNumber) {
		return firstNumber / secondNumber;
	}

}
