package hu.schonherz.homework.demo;

import hu.schonherz.homework.math.MathOperationMaker;

/**
 * FacadePatternDemo class
 * 
 * @author Iványi-Nagy Gábor
 */
public class FacadePatternDemo {

	
	public static void main(String[] args) {

		MathOperationMaker mathOperationMaker = new MathOperationMaker();

		Integer firstNumber = 17;
		Integer secondNumber = 10;

		/**
		 * Print the results of the four operations
		 */
		System.out.println("firstNumber = " + firstNumber + "\tsecondNumber = " + secondNumber + "\n");
		System.out.println("Addition: " + mathOperationMaker.operatorAddition(firstNumber, secondNumber));
		System.out.println("Subtraction: " + mathOperationMaker.operatorSubtraction(firstNumber, secondNumber));
		System.out.println("Multiplication: " + mathOperationMaker.operatorMultiplication(firstNumber, secondNumber));
		System.out.println("Division: " + mathOperationMaker.operatorDivision(firstNumber, secondNumber));

	}

}
