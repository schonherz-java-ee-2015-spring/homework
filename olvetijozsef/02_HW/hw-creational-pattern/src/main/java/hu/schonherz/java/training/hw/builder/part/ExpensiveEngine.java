package hu.schonherz.java.training.hw.builder.part;

/**
 * Implements the expensive engine.
 * 
 * @author Ölveti József
 *
 */
public class ExpensiveEngine implements Engine {

	public static final String EXPENSIVE_ENGINE = "Expensive Engine";

	@Override
	public String name() {
		return EXPENSIVE_ENGINE;
	}

	@Override
	public float price() {
		return 400.0f;
	}
}
