package hu.schonherz.java.training.hw2.creationalpattern;

/**
 * Special Exception type for when not an appropriate ink type is used.
 * */
public class NotAnInkException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotAnInkException(){
		super("The given type is not an ink type!");
	}
}
