package hu.schonherz.java.training.homework.vehicle;

public class Car implements Vehicle {

	public void drive() {
		System.out.println("You're driving a car!");

	}

	public String getType() {
		return "Car";
	}
}
