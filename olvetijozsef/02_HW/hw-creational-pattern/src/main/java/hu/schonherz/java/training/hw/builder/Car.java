package hu.schonherz.java.training.hw.builder;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.hw.builder.part.Part;

/**
 * Implement the cars.
 * 
 * @author Ölveti József
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
	 * @return the part index
	 */
	public int addPart(Part part) {
		parts.add(part);
		return parts.size() - 1;
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
	 * Returns with the car parts String.
	 * 
	 * @return the car parts String
	 */
	public String showParts() {
		StringBuilder sb = new StringBuilder();
		for (Part part : parts) {
			sb.append("\nPart : " + part.name());
			sb.append(", Material : " + part.material().material());
			sb.append(", Price : " + part.price());
		}
		return sb.toString();
	}
}