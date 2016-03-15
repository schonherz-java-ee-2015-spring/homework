package hu.shonhetz.training.structural.pattern;

/**
 * @author Mark Bohan
 * 
 *         Use for nodes in an expression tree.
 *
 */
public interface IArithmethicNode {
	/**
	 * @return the value of the node.
	 */
	public double eval();
}
