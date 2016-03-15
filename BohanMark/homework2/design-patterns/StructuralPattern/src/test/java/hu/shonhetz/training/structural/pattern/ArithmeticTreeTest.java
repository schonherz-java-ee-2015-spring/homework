package hu.shonhetz.training.structural.pattern;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hu.shonhetz.training.structural.pattern.ArithmeticNode.Operation;

public class ArithmeticTreeTest {

	ArithmeticTree tree;

	@Before
	public void setUp() throws Exception {
		tree = new ArithmeticTree(new ArithmeticNode(
				  new ArithmeticLeaf(2), new ArithmeticLeaf(5), Operation.MUL));
	}

	@Test
	public void test() {
		assertEquals(10, tree.evalExpression(), 0.0);
	}

}
