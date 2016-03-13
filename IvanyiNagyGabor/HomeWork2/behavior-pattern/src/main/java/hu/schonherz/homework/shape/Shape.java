package hu.schonherz.homework.shape;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Shap abstract class
 * 
 * @author Iványi-Nagy Gábor
 */
public abstract class Shape {

	/**
	 * Easily readable format
	 * example: "2016. August 10. 12:00:00"
	 * Year. MonthName Day. Hour:Minute:Second
	 */
	protected static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MMMM dd. HH:mm:ss");

	/**
	 * 
	 * @return the district
	 */
	public abstract Double calculateDistrict();

	/**
	 * 
	 * @return the area
	 */
	public abstract Double calculateArea();

	/**
	 * Template method that prints the summaryReport about the Shape objects
	 */
	public final void showSummaryReport() {
		System.out.println("Shape type: " + getClass().getSimpleName());
		System.out.println("District: " + String.format("%.1f", calculateDistrict()) + " unit");
		System.out.println("Area: " + String.format("%.1f", calculateArea()) + " unit");
		System.out.println("Created at: " + LocalDateTime.now().format(formatter));
	}
}
