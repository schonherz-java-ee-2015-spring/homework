package hu.shonhetz.training.behavioral.patern;


/**
 * @author Mark Bohan
 * iterator for matrix.
 *
 */
public interface IMatrixIterator <T>{
	public boolean hasNext();
	public T next();
}
