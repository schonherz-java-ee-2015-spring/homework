package hu.schonherz.java.training.homework.vehicle;

public class Bus implements Vehicle {

	public void drive() {
		System.out.println("You're driving a bus!");
	}

	public String getType() {
		return "Bus";
	}
}
