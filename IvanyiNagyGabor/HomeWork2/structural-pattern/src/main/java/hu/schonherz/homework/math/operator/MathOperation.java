package hu.schonherz.homework.math.operator;

/**
 * MathOperation interface for mathematic operations with Integer numbers
 * 
 * @author Iványi-Nagy Gábor
 */

@FunctionalInterface
public interface MathOperation {

	Integer operator(Integer firstNumber, Integer secondNumber);
}
