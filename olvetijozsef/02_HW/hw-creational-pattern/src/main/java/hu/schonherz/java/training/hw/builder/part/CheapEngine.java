package hu.schonherz.java.training.hw.builder.part;

/**
 * Implements the cheap engine.
 * 
 * @author Ölveti József
 *
 */
public class CheapEngine implements Engine {

	@Override
	public String name() {
		return "Cheap Engine";
	}

	@Override
	public float price() {
		return 100.0f;
	}
}
