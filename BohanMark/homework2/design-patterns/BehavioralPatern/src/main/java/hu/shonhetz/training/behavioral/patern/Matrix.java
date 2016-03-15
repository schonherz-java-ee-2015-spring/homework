package hu.shonhetz.training.behavioral.patern;

/**
 * Simple matrix.
 * 
 * @param <T>
 *            is the type of elements in the matrix
 * @author Mark Bohan
 */
public class Matrix<T> {

	private int n;
	private int m;

	T[][] elements;

	/**
	 * 
	 * @param n
	 *            is the width of the matrix
	 * @param m
	 *            is the height of the matrix
	 */
	@SuppressWarnings("unchecked")
	public Matrix(int n, int m) {
		super();
		this.n = n;
		this.m = m;
		elements = (T[][]) new Object[n][m];

	}

	@SuppressWarnings("javadoc")
	public T[][] getElements() {
		return elements;
	}
	
	@SuppressWarnings("javadoc")
	public T getElement(int i, int j) {
		return elements[i][j];
	}

	/**
	 * Set an element.
	 * 
	 * @param i
	 *            is the first coordinate of element
	 * @param j
	 *            is the second coordinate of element
	 * @param val
	 *            is the value of the element
	 */
	public void setElement(int i, int j, T val) {
		elements[i][j] = val;
	}

	@SuppressWarnings("javadoc")
	public int getN() {
		return n;
	}

	@SuppressWarnings("javadoc")
	public int getM() {
		return m;
	}

}
