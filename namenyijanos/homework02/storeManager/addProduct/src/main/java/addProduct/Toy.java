package addProduct;

public abstract class Toy {
	int barcode;
	float price;
	String name;

	public int getBarcode() {
		return barcode;
	}

	public float getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public Toy(int barcode, float price, String name) {
		super();
		this.barcode = barcode;
		this.price = price;
		this.name = name;
	}

	public Toy() {
		super();
		this.price = 9.99f;
	}
}
