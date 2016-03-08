package hu.schonherz.java.training.hw.builder.part;

/**
 * Implements the expensive engines.
 * 
 * @author Ölveti József
 *
 */
public class ExpensiveEngine implements Engine {
	@Override
	public String name() {
		return "Expensive Engine";
	}

	@Override
	public float price() {
		return 400.0f;
	}
}
