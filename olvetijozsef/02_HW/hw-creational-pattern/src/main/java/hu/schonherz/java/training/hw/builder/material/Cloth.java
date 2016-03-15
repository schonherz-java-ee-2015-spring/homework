package hu.schonherz.java.training.hw.builder.material;

/**
 * Implements the cloth material.
 * 
 * @author Ölveti József
 *
 */
public class Cloth implements Material {
	public static final String CLOTH = "Cloth";

	@Override
	public String material() {
		return CLOTH;
	}
}
