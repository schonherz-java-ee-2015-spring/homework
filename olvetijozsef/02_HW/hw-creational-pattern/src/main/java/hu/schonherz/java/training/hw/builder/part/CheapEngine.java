package hu.schonherz.java.training.hw.builder.part;

/**
 * Implements the cheap engine.
 * 
 * @author Ölveti József
 *
 */
public class CheapEngine implements Engine {

	public static final String CHEAP_ENGINE = "Cheap Engine";

	@Override
	public String name() {
		return CHEAP_ENGINE;
	}

	@Override
	public float price() {
		return 100.0f;
	}
}
