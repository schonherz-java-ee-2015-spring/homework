package hu.schonherz.java.training.homework.patient;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CareTakerTest {

	@Test
	public void testCareTaker() {
		CareTaker careTaker = new CareTaker();
		ConditionHandler condHandler = new ConditionHandler();

		condHandler.setCondition("Tired");
		careTaker.add(condHandler.saveConditionToMemory());
		condHandler.getConditionFromMemory(careTaker.get(0));

		assertEquals("Tired", condHandler.getCondition());

	}

}
