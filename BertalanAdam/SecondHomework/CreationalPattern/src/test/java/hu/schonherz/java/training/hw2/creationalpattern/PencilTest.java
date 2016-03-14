package hu.schonherz.java.training.hw2.creationalpattern;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class PencilTest {

private static AdelPencil ap;
private static LintonPencil lp;
	
	@BeforeClass
	public static void setUp(){
		ap = new AdelPencil();
		lp = new LintonPencil();
	}
	
	@Test(expected=NotSharpenerException.class)
	public void TestBadSharpeningAP(){
			ap.sharpen(-1);
	}
	
	@Test(expected=NotSharpenerException.class)
	public void TestBadSharpeningLP(){
			lp.sharpen(-1);
	}
	
	@Test
	public void testGoodSharpening() {
		
		int value = 5;
		
		String result = ap.sharpen(value);
		
		String expected = "Sharpening with the " + value + ". type sharpener.";
		assertEquals("Not the same value", expected, result);
		
		result = lp.sharpen(value);
		assertEquals("Not the same value", expected, result);
	}
}
