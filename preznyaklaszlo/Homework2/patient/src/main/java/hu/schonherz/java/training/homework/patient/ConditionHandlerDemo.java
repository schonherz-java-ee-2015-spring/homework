package hu.schonherz.java.training.homework.patient;

public class ConditionHandlerDemo {

	public static void main(String[] args) {
		CareTaker careTaker = new CareTaker();
		ConditionHandler condHandler = new ConditionHandler();

		condHandler.setCondition("Tired");
		careTaker.add(condHandler.saveConditionToMemory());

		condHandler.setCondition("Hypertension");
		careTaker.add(condHandler.saveConditionToMemory());

		condHandler.setCondition("Arrhythmia");
		condHandler.setCondition("Dizziness");
		careTaker.add(condHandler.saveConditionToMemory());

		condHandler.getConditionFromMemory(careTaker.get(0));
		System.out.println("First saved condition: " + condHandler.getCondition());
		condHandler.getConditionFromMemory(careTaker.get(1));
		System.out.println("Second saved condition: " + condHandler.getCondition());

	}

}
