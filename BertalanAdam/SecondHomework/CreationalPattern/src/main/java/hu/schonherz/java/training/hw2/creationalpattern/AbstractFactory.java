package hu.schonherz.java.training.hw2.creationalpattern;

// I think this functionality violates the Single Responsibility Principle
/**
 * The super factory that defines two functionalities in this situation.
 * */
public interface AbstractFactory {
	/**
	 * Defines how to create a {@link Pen}.
	 * @return The created {@link Pen} object.
	 * */
	Pen createPen();
	
	/**
	 * Defines how to create a {@link Pencil}.
	 * @return The created {@link Pencil} object.
	 * */
	Pencil createPencil();
}
