package hu.schonherz.java.training.hw.builder.material;

/**
 * Implements the metal material.
 * 
 * @author Ölveti József
 *
 */
public class Metal implements Material {
	public static final String METAL = "Metal";

	@Override
	public String material() {
		return METAL;
	}
}
