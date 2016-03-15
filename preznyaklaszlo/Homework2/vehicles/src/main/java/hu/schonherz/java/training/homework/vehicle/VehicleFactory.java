package hu.schonherz.java.training.homework.vehicle;

public class VehicleFactory {

	// Use getVehicle method to get object of type vehicle
	public Vehicle getVehicle(String vehicleType) {
		if (vehicleType == null) {
			return null;
		}
		if (vehicleType.equalsIgnoreCase("car")) {
			return new Car();
		}
		if (vehicleType.equalsIgnoreCase("bike")) {
			return new Bike();
		}
		if (vehicleType.equalsIgnoreCase("bus")) {
			return new Bus();
		}

		return null;
	}

}
