package hu.schonherz.java.training.hw.builder;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.hw.builder.part.Part;

/**
 * Represents the cars.
 * 
 * @author Joc
 *
 */
public class Car {
	/**
	 * List of the car parts.
	 */
	private List<Part> parts = new ArrayList<Part>();

	/**
	 * Add a part to the parts list.
	 * 
	 * @param part
	 *            a Part object
	 */
	public void addPart(Part part) {
		parts.add(part);
	}

	/**
	 * Returns with the car total cost.
	 * 
	 * @return the total cost.
	 */
	public float getCost() {
		float cost = 0.0f;

		for (Part part : parts) {
			cost += part.price();
		}
		return cost;
	}

	/**
	 * Print the car parts.
	 */
	public void showParts() {
		for (Part part : parts) {
			System.out.print("Part : " + part.name());
			System.out.print(", Packing : " + part.material().material());
			System.out.println(", Price : " + part.price());
		}
	}
}