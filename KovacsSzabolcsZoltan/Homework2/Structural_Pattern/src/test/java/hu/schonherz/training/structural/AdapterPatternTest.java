package hu.schonherz.training.structural;

import org.junit.*;
import static org.junit.Assert.*;

public class AdapterPatternTest {

	//Testing the converter (makeFit()) method
	@Test
	public void makeFitTest() {
		RoundHole rh = AdapterPattern.rh;
		boolean condition;
		SquarePegAdapter spa = new SquarePegAdapter((double) 8);
		spa.makeFit(rh);
		double width = SquarePegAdapter.sp.getWidth();
//		System.out.println(width);
		double actual = 7.0710678118654755;
		if (Double.compare(width, actual) == 0) {
			condition = true;
		} else {
			condition = false;
		}
		assertTrue("The makeFit method working good!", condition);
	}

}
