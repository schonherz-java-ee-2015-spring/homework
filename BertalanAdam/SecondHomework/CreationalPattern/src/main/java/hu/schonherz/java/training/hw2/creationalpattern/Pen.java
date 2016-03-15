package hu.schonherz.java.training.hw2.creationalpattern;

/**
 * Class that represents a pen functionality.
 * */
public abstract class Pen {
	/**
	 * Defines that how a pen writes.
	 * @return The written text as a {@link String}.
	 * */
	public abstract String write();
	
	/**
	 * Defines the ink refilling operation.
	 * @param An ink color described by an int.
	 * @return A message with the operation result as a {@link String}.
	 * */
	public abstract String refillInk( int inkColor ) throws NotAnInkException;
}
