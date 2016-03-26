package addProduct;

public class ToyFactory {

	public Toy getToy(String toyType) {

		// The getToy() method will return the kind of object it got as a
		// parameter except it is not valid or null
		if (toyType == null) {
			return null;
		}

		if (toyType.equalsIgnoreCase("DOLL")) {
			return new Doll();
		}

		if (toyType.equalsIgnoreCase("CAR")) {
			return new Car();
		}

		if (!(toyType.equalsIgnoreCase("DOLL")) && !(toyType.equalsIgnoreCase("CAR"))) {
			return null;
		}
		return null;
	}
}
