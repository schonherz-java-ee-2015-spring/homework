package hu.schonherz.java.training.hw.builder.part;

import hu.schonherz.java.training.hw.builder.material.Cloth;
import hu.schonherz.java.training.hw.builder.material.Material;

/**
 * Interface for car seats.
 * 
 * @author Ölveti József
 *
 */
public interface Seat extends Part {

	@Override
	default Material material() {
		return new Cloth();
	}
}
