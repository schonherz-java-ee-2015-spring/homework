package hu.schonherz.homework.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.homework.shape.Circle;
import hu.schonherz.homework.shape.Rectangle;
import hu.schonherz.homework.shape.Shape;
import hu.schonherz.homework.shape.Square;

/**
 * Test for Rectangle, Square and Circle objects
 * 
 * @author Iványi-Nagy Gábor
 */
public class ShapeTest {

	private static final Double DELTA = 1e-15;

	/**
	 * Test Rectangle: calculateDistrict() and calculateArea() methods
	 */
	@Test
	public void rectangleTest() {
		Shape rectangle = new Rectangle(1.0, 2.2);

		assertEquals(6.4, rectangle.calculateDistrict(), DELTA);
		assertEquals(2.2, rectangle.calculateArea(), DELTA);
	}

	/**
	 * Test Square: calculateDistrict() and calculateArea() methods
	 */
	@Test
	public void squareTest() {
		Shape square = new Square(4.12);

		assertEquals(16.48, square.calculateDistrict(), DELTA);
		assertEquals(16.9744, square.calculateArea(), DELTA);
	}

	/**
	 * Test Circle: calculateDistrict() and calculateArea() methods
	 */
	@Test
	public void circleTest() {
		Shape circle = new Circle(6.0);

		assertEquals(12 * Math.PI, circle.calculateDistrict(), DELTA);
		assertEquals(36 * Math.PI, circle.calculateArea(), DELTA);
	}
}
