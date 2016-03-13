package hu.schonherz.homework.shape;

import hu.schonherz.homework.shape.Shape;

/**
 * Rectangle class extended from the Shape
 * 
 * @author Iványi-Nagy Gábor
 */
public class Rectangle extends Shape {

	private Double sideA;
	private Double sideB;

	/**
	 * @param sideA
	 *            the sideA to set
	 * @param sideB
	 *            the sideB to set
	 */
	public Rectangle(Double sideA, Double sideB) {
		super();
		this.sideA = sideA;
		this.sideB = sideB;
	}

	/**
	 * @return the sideA
	 */
	public Double getSideA() {
		return sideA;
	}

	/**
	 * @param sideA
	 *            the sideA to set
	 */
	public void setSideA(Double sideA) {
		this.sideA = sideA;
	}

	/**
	 * @return the sideB
	 */
	public Double getSideB() {
		return sideB;
	}

	/**
	 * @param sideB
	 *            the sideB to set
	 */
	public void setSideB(Double sideB) {
		this.sideB = sideB;
	}

	/**
	 * @return the district of the Rectangle
	 */
	@Override
	public Double calculateDistrict() {
		return 2.0 * (sideA + sideB);
	}

	/**
	 * @return the area of the Rectangle
	 */
	@Override
	public Double calculateArea() {
		return sideA * sideB;
	}

}
