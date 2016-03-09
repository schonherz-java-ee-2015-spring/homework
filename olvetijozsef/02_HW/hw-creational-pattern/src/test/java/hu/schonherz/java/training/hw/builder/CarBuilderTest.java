package hu.schonherz.java.training.hw.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.part.CheapEngine;
import hu.schonherz.java.training.hw.builder.part.ClothSeat;
import hu.schonherz.java.training.hw.builder.part.ExpensiveEngine;
import hu.schonherz.java.training.hw.builder.part.LeatherSeat;
import hu.schonherz.java.training.hw.builder.part.WoodSeat;

public class CarBuilderTest {

	@Test
	public void testCreateCheapCar() {
		Car testCar = new Car();
		testCar.addPart(new CheapEngine());
		testCar.addPart(new WoodSeat());

		CarBuilder cb = new CarBuilder();
		Car car = cb.createCheapCar();
		assertEquals(testCar.showParts(),car.showParts());
	}

	@Test
	public void testCreateExpensiveCar() {
		Car testCar = new Car();
		testCar.addPart(new ExpensiveEngine());
		testCar.addPart(new LeatherSeat());

		CarBuilder cb = new CarBuilder();
		Car car = cb.createExpensiveCar();
		assertEquals(testCar.showParts(), car.showParts());
	}

	@Test
	public void testCreateCityCar() {
		Car testCar = new Car();
		testCar.addPart(new CheapEngine());
		testCar.addPart(new ClothSeat());

		CarBuilder cb = new CarBuilder();
		Car car = cb.createCityCar();
		assertEquals(testCar.showParts(), car.showParts());
	}
}
