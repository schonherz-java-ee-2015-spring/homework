package hu.schonherz.java.training.homework.patient;

//This class us used to handle the conditions
public class ConditionHandler {

	private String condition;

	// Sets the condiion
	public void setCondition(String condition) {
		this.condition = condition;
	}

	// Returns the condition of the patient
	public String getCondition() {
		return condition;
	}

	// Saves the condition
	public Condition saveConditionToMemory() {
		return new Condition(condition);
	}

	// Gets the condition from the memory
	public void getConditionFromMemory(Condition Condition) {
		condition = Condition.getCondition();
	}

}
