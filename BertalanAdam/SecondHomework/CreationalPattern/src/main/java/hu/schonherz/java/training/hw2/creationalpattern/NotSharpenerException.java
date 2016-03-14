package hu.schonherz.java.training.hw2.creationalpattern;

/**
 * Special Exception type for when an inappropriate sharpener type is used.
 * */
public class NotSharpenerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotSharpenerException() {
		super("Not a sharpener type!");
	}
	
}
