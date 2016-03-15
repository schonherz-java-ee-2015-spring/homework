package hu.schonherz.java.training.hw.builder.material;

/**
 * Implements the leather material.
 * 
 * @author Ölveti József
 *
 */
public class Leather implements Material {
	public static final String LEATHER = "Leather";

	@Override
	public String material() {
		return LEATHER;
	}
}
