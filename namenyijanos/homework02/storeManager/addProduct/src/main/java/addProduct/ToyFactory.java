package addProduct;

public class ToyFactory {

	public Toy getToy(String toyType) {

		if (toyType == null) {
			return null;
		}

		if (toyType.equalsIgnoreCase("DOLL")) {
			return new Doll();
		}

		if (toyType.equalsIgnoreCase("CAR")) {
			return new Car();
		}
		return null;
	}
}
