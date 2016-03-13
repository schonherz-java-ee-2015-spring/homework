package hu.schonherz.homework.addProduct;

public class Car extends Toy {

	public Car(int barcode, float price, String name) {
		super(barcode, price, name);
	}

	public Car() {
		super();
		this.barcode = 88889999;
		this.name = "BatMobile";
	}

}
