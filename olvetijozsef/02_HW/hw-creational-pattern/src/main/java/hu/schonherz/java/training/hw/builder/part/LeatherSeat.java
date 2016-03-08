package hu.schonherz.java.training.hw.builder.part;

import hu.schonherz.java.training.hw.builder.material.Leather;
import hu.schonherz.java.training.hw.builder.material.Material;

/**
 * Implements the leather seats.
 * 
 * @author Ölveti József
 *
 */
public class LeatherSeat implements Seat {

	@Override
	public Material material() {
		return new Leather();
	}

	@Override
	public String name() {
		return "Leather Seat";
	}

	@Override
	public float price() {
		return 50.0f;
	}
}
