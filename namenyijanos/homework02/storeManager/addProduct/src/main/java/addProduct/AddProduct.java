package addProduct;

public class AddProduct {
	final static char CURRENCY = '$';

	public static void main(String[] args) {
		//toyFactory object will create the concrete toy objects
		ToyFactory toyFactory = new ToyFactory();

		//call the getToy method which returns an object from the desired class
		Toy toy1 = toyFactory.getToy("doll");
		Toy toy2 = toyFactory.getToy("car");

		System.out.println("Creating two products...\n");

		//inform the user the objects created
		System.out.println("Toy1 is a doll. Name: " + toy1.getName() + ". Price: " + CURRENCY + toy1.getPrice()
				+ ". Barcode: " + toy1.getBarcode() + ".");
		System.out.println("Toy2 is a car. Name: " + toy2.getName() + ". Price: " + CURRENCY + toy2.getPrice()
				+ ". Barcode: " + toy2.getBarcode() + ".");
	}

}
