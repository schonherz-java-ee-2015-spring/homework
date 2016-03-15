package hu.schonherz.java.training.homework.patient;

public class ConditionHandler {

	private String condition;

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
	}

	public Condition saveConditionToMemory() {
		return new Condition(condition);
	}

	public void getConditionFromMemory(Condition Condition) {
		condition = Condition.getCondition();
	}

}
