package hu.shonhetz.training.behavioral.patern;

/**
 * @author s01y0m
 *
 * @param <T>
 */
public class MainDiagonalIterator<T> implements IMatrixIterator<T> {

	private Matrix<T> matrix;
	private int i=0;
	
	@SuppressWarnings("javadoc")
	public MainDiagonalIterator(Matrix matrix) {
		super();
		this.matrix = matrix;
	}

	public boolean hasNext() {
		return i<matrix.getN() && i < matrix.getM();
	}

	public T next() {
		return matrix.getElement(i, i++);
	}

}
