package hu.schonherz.java.training.hw.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.part.CheapEngine;
import hu.schonherz.java.training.hw.builder.part.ClothSeat;
import hu.schonherz.java.training.hw.builder.part.ExpensiveEngine;
import hu.schonherz.java.training.hw.builder.part.LeatherSeat;
import hu.schonherz.java.training.hw.builder.part.WoodSeat;

public class CarBuilderTest {
	private static CarBuilder cb = new CarBuilder();

	@Test
	public void testCreateCheapCar() {
		Car car = cb.createCheapCar();
		Car testCar = new Car();
		testCar.addPart(new CheapEngine());
		testCar.addPart(new WoodSeat());
		assertEquals(testCar.showParts(),car.showParts());
	}

	@Test
	public void testCreateExpensiveCar() {
		Car car = cb.createExpensiveCar();
		Car testCar = new Car();
		testCar.addPart(new ExpensiveEngine());
		testCar.addPart(new LeatherSeat());
		assertEquals(testCar.showParts(), car.showParts());
	}

	@Test
	public void testCreateCityCar() {
		Car car = cb.createCityCar();
		Car testCar = new Car();
		testCar.addPart(new CheapEngine());
		testCar.addPart(new ClothSeat());
		assertEquals(testCar.showParts(), car.showParts());
	}
}
