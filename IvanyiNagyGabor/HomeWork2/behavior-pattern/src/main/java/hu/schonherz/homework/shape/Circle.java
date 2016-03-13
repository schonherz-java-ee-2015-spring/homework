package hu.schonherz.homework.shape;

/**
 * Circle class extended from the Shape
 * 
 * @author Iványi-Nagy Gábor
 */
public class Circle extends Shape {

	private Double radius;

	/**
	 * @param radius
	 *            the radius to set
	 */
	public Circle(Double radius) {
		super();
		this.radius = radius;
	}

	/**
	 * @return the radius
	 */
	public Double getRadius() {
		return radius;
	}

	/**
	 * @param radius
	 *            the radius to set
	 */
	public void setRadius(Double radius) {
		this.radius = radius;
	}

	/**
	 * @return the district of the Circle
	 */
	@Override
	public Double calculateDistrict() {
		return 2.0 * radius * Math.PI;
	}

	/**
	 * @return the area of the Circle
	 */
	@Override
	public Double calculateArea() {
		return Math.pow(radius, 2) * Math.PI;
	}

}
