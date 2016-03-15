package hu.schonherz.java.training.homework.vehicle;

public class VehicleFactoryDemo {

	public static void main(String[] args) {
		VehicleFactory vehicleFactory = new VehicleFactory();

		// get an object of Car
		Vehicle vehicle1 = vehicleFactory.getVehicle("car");

		// Calling the drive method of Car
		vehicle1.drive();

		// get an object of Bike
		Vehicle vehicle2 = vehicleFactory.getVehicle("bike");

		// Calling the drive method of Bike
		vehicle2.drive();

		// get an object of Bus
		Vehicle vehicle3 = vehicleFactory.getVehicle("bus");

		// Calling the drive method of Bus
		vehicle3.drive();

	}

}
