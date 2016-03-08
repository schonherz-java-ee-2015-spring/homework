package hu.schonherz.java.training.hw.builder;

import hu.schonherz.java.training.hw.builder.part.CheapEngine;
import hu.schonherz.java.training.hw.builder.part.ClothSeat;
import hu.schonherz.java.training.hw.builder.part.ExpensiveEngine;
import hu.schonherz.java.training.hw.builder.part.LeatherSeat;
import hu.schonherz.java.training.hw.builder.part.WoodSeat;

/**
 * This is the car builder machine.
 * 
 * @author Ölveti József
 *
 */
public class CarBuilder {

	/**
	 * Creates a cheap car.
	 * 
	 * @return a Car object
	 */
	public Car createCheapCar() {
		Car car = new Car();
		car.addPart(new CheapEngine());
		car.addPart(new WoodSeat());
		return car;
	}

	/**
	 * Creates an expensive car.
	 * 
	 * @return a Car object
	 */
	public Car createExpensiveCar() {
		Car car = new Car();
		car.addPart(new ExpensiveEngine());
		car.addPart(new LeatherSeat());
		return car;
	}

	/**
	 * Creates a city car.
	 * 
	 * @return a Car object
	 */
	public Car createCityCar() {
		Car car = new Car();
		car.addPart(new CheapEngine());
		car.addPart(new ClothSeat());
		return car;
	}
}
