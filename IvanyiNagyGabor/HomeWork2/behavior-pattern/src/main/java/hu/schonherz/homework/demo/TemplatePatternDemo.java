package hu.schonherz.homework.demo;

import hu.schonherz.homework.shape.Circle;
import hu.schonherz.homework.shape.Rectangle;
import hu.schonherz.homework.shape.Shape;
import hu.schonherz.homework.shape.Square;

/**
 * TemplatePattern Demo for the summaryReport of Shapes
 * 
 * @author Iványi-Nagy Gábor
 */
public class TemplatePatternDemo {

	public static void main(String[] args) {
		Shape shape = new Rectangle(1.2, 1.5);
		shape.showSummaryReport();
		System.out.println();

		shape = new Square(5.0);
		shape.showSummaryReport();
		System.out.println();

		shape = new Circle(3.14);
		shape.showSummaryReport();
		System.out.println();
	}
}
