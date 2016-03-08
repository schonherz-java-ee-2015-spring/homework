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
		System.out.println("Cheap Car");
		cheapCar.showParts();
		System.out.println("Total Cost: " + cheapCar.getCost());

		Car expCar = carBuilder.createExpensiveCar();
		System.out.println("Expensive Car");
		expCar.showParts();
		System.out.println("Total Cost: " + expCar.getCost());

		Car cityCar = carBuilder.createCityCar();
		System.out.println("City Car");
		cityCar.showParts();
		System.out.println("Total Cost: " + cityCar.getCost());
	}

}
