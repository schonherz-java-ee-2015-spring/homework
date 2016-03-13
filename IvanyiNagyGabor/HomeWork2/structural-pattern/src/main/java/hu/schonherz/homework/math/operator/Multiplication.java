package hu.schonherz.homework.math.operator;

/**
 * Multiplication class that implements MathOperation interface
 * 
 * @author Iványi-Nagy Gábor
 */
public class Multiplication implements MathOperation {

	/**
	 * @return the product of the multiplication of the two parameter numbers
	 */
	@Override
	public Integer operator(Integer firstNumber, Integer secondNumber) {
		return firstNumber * secondNumber;
	}

}
