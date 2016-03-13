package hu.schonherz.homework.addProduct;

public class Doll extends Toy {

	public Doll(int barcode, float price, String name) {
		super(barcode, price, name);
	}

	public Doll() {
		super();
		this.barcode = 99998888;
		this.name = "BabyDoll";
	}

}
