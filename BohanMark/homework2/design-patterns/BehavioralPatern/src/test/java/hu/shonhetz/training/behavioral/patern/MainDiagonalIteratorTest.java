package hu.shonhetz.training.behavioral.patern;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class MainDiagonalIteratorTest {

	Matrix<Integer> matrix;
	
	@Before
	public void setUp() throws Exception {
		matrix = new Matrix<Integer>(3, 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix.setElement(i, j, i+j);
			}
		}
	}

	@Test
	public void test() {
		MainDiagonalIterator<Integer> iterator= new MainDiagonalIterator<Integer>(matrix);
		
		assertEquals(true, iterator.hasNext());
		assertEquals((Integer)0, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals((Integer)2, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals((Integer)4, iterator.next());
		assertEquals(false, iterator.hasNext());
		
	}

}
