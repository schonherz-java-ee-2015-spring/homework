package hu.schonherz.java.training.hw.builder.part;

import hu.schonherz.java.training.hw.builder.material.Material;
import hu.schonherz.java.training.hw.builder.material.Wood;

/**
 * Implements the wood seats.
 * 
 * @author Ölveti József
 *
 */
public class WoodSeat implements Seat {

	public static final String WOOD_SEAT = "Wood Seat";

	@Override
	public String name() {
		return WOOD_SEAT;
	}

	@Override
	public float price() {
		return 5.0f;
	}

	@Override
	public Material material() {
		return new Wood();
	}
}
