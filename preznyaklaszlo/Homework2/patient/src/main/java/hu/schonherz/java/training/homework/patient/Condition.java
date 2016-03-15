package hu.schonherz.java.training.homework.patient;

//This class is used to store a condition of a patient in a hostpital, for ex.
public class Condition {

	private String condition;

	public Condition(String condition) {
		this.condition = condition;
	}

	// Returns the condition
	public String getCondition() {
		return condition;
	}

}
