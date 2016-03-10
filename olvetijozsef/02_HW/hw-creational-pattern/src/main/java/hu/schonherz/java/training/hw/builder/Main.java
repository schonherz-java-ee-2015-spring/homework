package hu.schonherz.java.training.hw.builder;

/**
 * The Application.
 * 
 * @author Ölveti József
 *
 */
public class Main {

	public static void main(String[] args) {

		CarBuilder carBuilder = new CarBuilder();

		Car cheapCar = carBuilder.createCheapCar();
		System.out.print("Cheap Car");
		System.out.println(cheapCar.showParts());
		System.out.println("Total Cost: " + cheapCar.getCost());
		System.out.println();

		Car expCar = carBuilder.createExpensiveCar();
		System.out.print("Expensive Car");
		System.out.println(expCar.showParts());
		System.out.println("Total Cost: " + expCar.getCost());
		System.out.println();

		Car cityCar = carBuilder.createCityCar();
		System.out.print("City Car");
		System.out.println(cityCar.showParts());
		System.out.println("Total Cost: " + cityCar.getCost());
	}
}
