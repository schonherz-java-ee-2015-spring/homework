package hu.schonherz.java.training.hw2.creationalpattern;

/**
 * A class to represent a pencil's functionality
 * */
public abstract class Pencil {
	
	/**
	 * Defines how a pencil draws.
	 * */
	public abstract void draw();
	
	/**
	 * Defines how a pencil can be sharpened.
	 * @param A sharpener type described by an int.
	 * @return A message with the operation result as a {@link String}.
	 * */
	public abstract String sharpen( int sharpener ) throws NotSharpenerException;
}
