package hu.schonherz.homework.math;

import hu.schonherz.homework.math.operator.Addition;
import hu.schonherz.homework.math.operator.Division;
import hu.schonherz.homework.math.operator.MathOperation;
import hu.schonherz.homework.math.operator.Multiplication;
import hu.schonherz.homework.math.operator.Subtraction;

/**
 * MathOperationMaker class
 * 
 * @author Iványi-Nagy Gábor
 */
public class MathOperationMaker {

	/**
	 * create four MathOperation to the basic operations
	 */
	private MathOperation addition;
	private MathOperation subtraction;
	private MathOperation multiplication;
	private MathOperation division;

	/**
	 * Create instances
	 */
	public MathOperationMaker() {
		addition = new Addition();
		subtraction = new Subtraction();
		multiplication = new Multiplication();
		division = new Division();
	}

	/**
	 * 
	 * @param firstNumber
	 *            type is Integer
	 * @param secondNumber
	 *            type is Integer
	 * @return firstNumber + secondNumber
	 */
	public Integer operatorAddition(Integer firstNumber, Integer secondNumber) {
		return addition.operator(firstNumber, secondNumber);
	}

	/**
	 * 
	 * @param firstNumber
	 *            type is Integer
	 * @param secondNumber
	 *            type is Integer
	 * @return firstNumber - secondNumber
	 */
	public Integer operatorSubtraction(Integer firstNumber, Integer secondNumber) {
		return subtraction.operator(firstNumber, secondNumber);
	}

	/**
	 * 
	 * @param firstNumber
	 *            type is Integer
	 * @param secondNumber
	 *            type is Integer
	 * @return firstNumber * secondNumber
	 */
	public Integer operatorMultiplication(Integer firstNumber, Integer secondNumber) {
		return multiplication.operator(firstNumber, secondNumber);
	}

	/**
	 * 
	 * @param firstNumber
	 *            type is Integer
	 * @param secondNumber
	 *            type is Integer
	 * @return firstNumber / secondNumber
	 */
	public Integer operatorDivision(Integer firstNumber, Integer secondNumber) {
		return division.operator(firstNumber, secondNumber);
	}

}
