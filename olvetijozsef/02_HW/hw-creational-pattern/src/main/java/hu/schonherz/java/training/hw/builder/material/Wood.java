package hu.schonherz.java.training.hw.builder.material;

/**
 * Implements the wood material.
 * 
 * @author Ölveti József
 *
 */
public class Wood implements Material {
	public static final String WOOD = "Wood";

	@Override
	public String material() {
		return WOOD;
	}
}
