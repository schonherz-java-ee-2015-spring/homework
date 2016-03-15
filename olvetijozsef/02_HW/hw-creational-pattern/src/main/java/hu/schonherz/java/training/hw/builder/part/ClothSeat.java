package hu.schonherz.java.training.hw.builder.part;

import hu.schonherz.java.training.hw.builder.material.Cloth;
import hu.schonherz.java.training.hw.builder.material.Material;

/**
 * Implements the cloth seats.
 * 
 * @author Ölveti József
 *
 */
public class ClothSeat implements Seat {

	public static final String CLOTH_SEAT = "Cloth Seat";

	@Override
	public Material material() {
		return new Cloth();
	}

	@Override
	public String name() {
		return CLOTH_SEAT;
	}

	@Override
	public float price() {
		return 25.0f;
	}

}
