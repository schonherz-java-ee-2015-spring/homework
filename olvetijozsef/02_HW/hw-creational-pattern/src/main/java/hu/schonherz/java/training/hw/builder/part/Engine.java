package hu.schonherz.java.training.hw.builder.part;

import hu.schonherz.java.training.hw.builder.material.Material;
import hu.schonherz.java.training.hw.builder.material.Metal;

/**
 * Interface for car engine.
 * 
 * @author Ölveti József
 *
 */
public interface Engine extends Part {

	@Override
	default Material material() {
		return new Metal();
	}
}
