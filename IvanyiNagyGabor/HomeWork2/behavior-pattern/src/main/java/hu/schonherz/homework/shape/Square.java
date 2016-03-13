package hu.schonherz.homework.shape;

/**
 * Square class extended from the Shape
 * 
 * @author Iványi-Nagy Gábor
 */
public class Square extends Shape {

	private Double sideA;

	/**
	 * @param sideA
	 *            the sideA to set
	 */
	public Square(Double sideA) {
		super();
		this.sideA = sideA;
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
	 * @return the district of Square
	 */
	@Override
	public Double calculateDistrict() {
		return 4.0 * sideA;
	}

	/**
	 * @return the area of the Square
	 */
	@Override
	public Double calculateArea() {
		return Math.pow(sideA, 2);
	}

}
