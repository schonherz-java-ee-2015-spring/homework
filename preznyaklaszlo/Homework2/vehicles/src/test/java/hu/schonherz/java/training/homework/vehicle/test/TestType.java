package hu.schonherz.java.training.homework.vehicle.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.java.training.homework.vehicle.Vehicle;
import hu.schonherz.java.training.homework.vehicle.VehicleFactory;

public class TestType {

	@Test
	public void testGetTypeCar() {
		VehicleFactory factory = new VehicleFactory();
		Vehicle vehicle = factory.getVehicle("car");
		assertEquals("Car", vehicle.getType());
	}

	@Test
	public void testGetTypeBike() {
		VehicleFactory factory = new VehicleFactory();
		Vehicle vehicle = factory.getVehicle("bike");
		assertEquals("Bike", vehicle.getType());
	}

	@Test
	public void testGetTypeBus() {
		VehicleFactory factory = new VehicleFactory();
		Vehicle vehicle = factory.getVehicle("bus");
		assertEquals("Bus", vehicle.getType());
	}

}