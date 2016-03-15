package hu.schonherz.java.training.hw.builder;

/**
 * The Application.
 * 
 * @author Ölveti József
 *
 */
public class Main {

	private static final String TOTAL_COST = "Total Cost: ";

	public static void main(String[] args) {

		CarBuilder carBuilder = new CarBuilder();

		Car cheapCar = carBuilder.createCheapCar();
		System.out.print("Cheap Car");
		System.out.println(cheapCar.showParts());
		System.out.println(TOTAL_COST + cheapCar.getCost());
		System.out.println();

		Car expCar = carBuilder.createExpensiveCar();
		System.out.print("Expensive Car");
		System.out.println(expCar.showParts());
		System.out.println(TOTAL_COST + expCar.getCost());
		System.out.println();

		Car cityCar = carBuilder.createCityCar();
		System.out.print("City Car");
		System.out.println(cityCar.showParts());
		System.out.println(TOTAL_COST + cityCar.getCost());
	}
}
