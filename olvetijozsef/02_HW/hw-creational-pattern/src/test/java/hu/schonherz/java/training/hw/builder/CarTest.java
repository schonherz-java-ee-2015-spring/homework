package hu.schonherz.java.training.hw.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.part.ClothSeat;
import hu.schonherz.java.training.hw.builder.part.ExpensiveEngine;
import hu.schonherz.java.training.hw.builder.part.Part;

public class CarTest {

	@Test
	public void testAddPart() {
		Car car = new Car();
		Part p = new ClothSeat();
		car.addPart(p);
		assertEquals(String.valueOf(25.0f), String.valueOf(car.getCost()));

		p = new ExpensiveEngine();
		car.addPart(p);
		assertEquals(String.valueOf(425.0f), String.valueOf(car.getCost()));
	}

}
