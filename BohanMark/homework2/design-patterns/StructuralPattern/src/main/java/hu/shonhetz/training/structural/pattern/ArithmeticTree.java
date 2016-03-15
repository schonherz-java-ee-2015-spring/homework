package hu.shonhetz.training.structural.pattern;

/**
 * @author Mark Bohan
 * 
 *         Use for calculating the value of an expression tree.
 *
 */
public class ArithmeticTree implements ArithmeticBridge {

	IArithmethicNode root;

	/**
	 * @param root
	 *            is the root of the expression tree
	 */
	public ArithmeticTree(IArithmethicNode root) {
		super();
		this.root = root;
	}

	public double evalExpression() {
		return root.eval();
	}

}
