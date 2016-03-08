package hu.schonherz.java.training.hw.builder.part;

/**
 * Implements the cloth seats.
 * 
 * @author Ölveti József
 *
 */
public class ClothSeat implements Seat {

	@Override
	public String name() {
		return "Cloth Seat";
	}

	@Override
	public float price() {
		return 25.0f;
	}

}
