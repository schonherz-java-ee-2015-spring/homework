package hu.schonherz.java.training.hw.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.part.CheapEngine;
import hu.schonherz.java.training.hw.builder.part.ClothSeat;
import hu.schonherz.java.training.hw.builder.part.ExpensiveEngine;
import hu.schonherz.java.training.hw.builder.part.LeatherSeat;

public class CarTest {

	@Test
	public void testAddPart() {
		Car car = new Car();
		int result = car.addPart(new ClothSeat());
		assertEquals(0, result);

		result = car.addPart(new ExpensiveEngine());
		assertEquals(1, result);
	}

	@Test
	public void testGetCost() {
		Car car = new Car();
		car.addPart(new ClothSeat());
		assertEquals(String.valueOf(25.0f), String.valueOf(car.getCost()));

		car.addPart(new ExpensiveEngine());
		assertEquals(String.valueOf(425.0f), String.valueOf(car.getCost()));
	}

	@Test
	public void testShowParts() {
		Car car = new Car();
		car.addPart(new LeatherSeat());
		car.addPart(new CheapEngine());
		String result= car.showParts();
		String expected = "\nPart : Leather Seat, Material : Leather, Price : 50.0";
		expected = expected + "\nPart : Cheap Engine, Material : Metal, Price : 100.0";
		assertEquals(expected, result);
	}

}
