package orderProduct;

public class Product {
	private String name;
	private int quantity;

	public void order() {
		System.out.println("Product [Name: " + name + "; Quantity: " + quantity + ".] ordered");
	}

	public void receive() {
		System.out.println("Product [Name: " + name + "; Quantity: " + quantity + ".] received");
	}

	public Product(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public Product() {
		super();
		this.name = "BabyDoll";
		this.quantity = 40;
	}

}
