package hu.shonhetz.training.structural.pattern;

/**
 * @author Mark Bohan
 * 
 *         the leafs of {@link ArithmeticTree}
 * @see ArithmeticNode
 * @see ArithmeticTree
 *
 */
public class ArithmeticLeaf implements IArithmethicNode {

	private double value;

	/**
	 * @param value
	 *            is the value of leaf
	 */
	public ArithmeticLeaf(double value) {
		this.value = value;
	}

	public double eval() {
		return value;
	}

	@SuppressWarnings("javadoc")
	public void setValue(double value) {
		this.value = value;
	}

}
