package hu.schonherz.java.training.hw2.creationalpattern;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

// This test class is the most important, because
// it tests the functionality of the abstract factory pattern
// that it really gives the correct objects back
public class AbstractFactoryTest {

	private static PenAndPencilFactory1 ppf1;
	private static PenAndPencilFactory2 ppf2;
	
	@BeforeClass
	public static void setUp(){
		ppf1 = new PenAndPencilFactory1();
		ppf2 = new PenAndPencilFactory2();
	}
	
	@Test
	public void testCreatePenOnFactory1(){		
		Object obj = ppf1.createPen();
		String expected = "hu.schonherz.java.training.hw2.creationalpattern.ZebraPen";
		
		assertEquals( "Not the appropriate class!", expected, obj.getClass().getName());
	}
	
	@Test
	public void testCreatePencilOnFactory1(){
		Object obj = ppf1.createPencil();
		String expected = "hu.schonherz.java.training.hw2.creationalpattern.LintonPencil";
		
		assertEquals( "Not the appropriate class!", expected, obj.getClass().getName());
	}
	
	@Test
	public void testCreatePenOnFactory2(){
		Object obj = ppf2.createPen();
		String expected = "hu.schonherz.java.training.hw2.creationalpattern.ParkerPen";
		
		assertEquals( "Not the appropriate class!", expected, obj.getClass().getName());
	}
	
	@Test
	public void testCreatePencilOnFactory2(){
		Object obj = ppf2.createPencil();
		String expected = "hu.schonherz.java.training.hw2.creationalpattern.AdelPencil";
		
		assertEquals( "Not the appropriate class!", expected, obj.getClass().getName());
	}


}
