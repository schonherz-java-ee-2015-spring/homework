package addProduct;

public class Car extends Toy {

	//constructor with custom user input
	public Car(int barcode, float price, String name) {
		super(barcode, price, name);
	}

	// constructor for create sample object if the input is not implemented
	public Car() {
		super();
		this.barcode = 88889999;
		this.name = "BatMobile";
	}

}
