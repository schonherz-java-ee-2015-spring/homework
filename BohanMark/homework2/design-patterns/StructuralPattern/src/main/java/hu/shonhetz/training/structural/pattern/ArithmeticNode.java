package hu.shonhetz.training.structural.pattern;

/**
 * 
 * 
 * Node for ArithmeticTree
 * 
 * @see ArithmeticLeaf
 * @see ArithmeticTree
 * @see ArithmeticBridge
 * @author Mark Bohan
 *
 */
public class ArithmeticNode implements IArithmethicNode {

	/**
	 * 
	 * Specifies the type of operation
	 *
	 */
	public enum Operation {
		/**
		 * Multiply
		 */
		MUL,
		/**
		 * Divide
		 */
		DIV,
		/**
		 * Addition
		 */
		ADD,
		/**
		 * 
		 */
		SUB
	};

	private IArithmethicNode rigth;
	private IArithmethicNode left;

	/**
	 * @param rigth
	 *            is the right side of operation
	 * @param left
	 *            is the left side of operation
	 * @param operation
	 *            is the type of operation
	 */
	public ArithmeticNode(IArithmethicNode rigth, IArithmethicNode left, Operation operation) {
		super();
		this.rigth = rigth;
		this.left = left;
		this.operation = operation;
	}

	Operation operation;

	public double eval() {
		switch (operation) {
		case MUL:
			return left.eval() * rigth.eval();
		case DIV:
			return left.eval() / rigth.eval();
		case ADD:
			return left.eval() + rigth.eval();
		}

		return left.eval() - rigth.eval();
	}

}
