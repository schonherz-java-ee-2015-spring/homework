package hu.schonherz.java.training.hw.builder.part;

import hu.schonherz.java.training.hw.builder.material.Material;

/**
 * Interface for car parts.
 * 
 * @author Ölveti József
 *
 */
public interface Part {

	/**
	 * Returns with the part name.
	 * 
	 * @return the part name String
	 */
	String name();

	/**
	 * Returns with the part price.
	 * 
	 * @return the part price
	 */
	float price();

	/**
	 * Returns with the part material.
	 * 
	 * @return a Material object
	 */
	Material material();
}
