package hu.schonherz.homework.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.schonherz.homework.math.operator.Addition;
import hu.schonherz.homework.math.operator.Division;
import hu.schonherz.homework.math.operator.MathOperation;
import hu.schonherz.homework.math.operator.Multiplication;
import hu.schonherz.homework.math.operator.Subtraction;

/**
 * Test for the four mathematic operators
 * 
 * @author Iványi-Nagy Gábor
 */
public class MathOperationTest {

	/**
	 * We will work these numbers for tests
	 */
	private final Integer ZERO = 0;
	private final Integer FIVE = 5;
	private final Integer TWENTY = 20;

	/**
	 * Addition test
	 */
	@Test
	public void additionTest() {
		MathOperation addition = new Addition();

		assertEquals(5, addition.operator(ZERO, FIVE).intValue());
		assertEquals(25, addition.operator(TWENTY, FIVE).intValue());
	}

	/**
	 * Subtraction test
	 */
	@Test
	public void subtractionTest() {
		MathOperation subtraction = new Subtraction();

		assertEquals(-5, subtraction.operator(ZERO, FIVE).intValue());
		assertEquals(15, subtraction.operator(TWENTY, FIVE).intValue());
	}

	/**
	 * Multiplication test
	 */
	@Test
	public void multiplicationTest() {
		MathOperation multiplication = new Multiplication();

		assertEquals(0, multiplication.operator(ZERO, FIVE).intValue());
		assertEquals(100, multiplication.operator(TWENTY, FIVE).intValue());
	}

	/**
	 * Division test without exception
	 */
	@Test
	public void divisionTest() {
		MathOperation division = new Division();

		assertEquals(0, division.operator(ZERO, FIVE).intValue());
		assertEquals(4, division.operator(TWENTY, FIVE).intValue());
	}

	/**
	 * Division test with exception
	 */
	@Test(expected = ArithmeticException.class)
	public void divisionByZeroTest() {
		MathOperation division = new Division();
		division.operator(TWENTY, ZERO);
	}

}
