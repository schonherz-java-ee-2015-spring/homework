package hu.shonhetz.training.structural.pattern;

/**
 * @author Mark Bohan
 * 
 *         Use for calculate an expression tree.
 *
 */
public interface ArithmeticBridge {
	/**
	 * @return the value of the expression
	 */
	public double evalExpression();
}
