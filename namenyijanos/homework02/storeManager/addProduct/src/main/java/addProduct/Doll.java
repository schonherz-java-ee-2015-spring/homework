package addProduct;

public class Doll extends Toy {

	// constructor with custom user input
	public Doll(int barcode, float price, String name) {
		super(barcode, price, name);
	}

	// constructor for create sample object if the input is not implemented
	public Doll() {
		super();
		this.barcode = 99998888;
		this.name = "BabyDoll";
	}

}
