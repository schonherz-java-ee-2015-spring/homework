package orderProduct;

public class ReceiveProduct implements Order {

	private Product productToReceive;

	public void execute() {
		productToReceive.receive();
	}

	public ReceiveProduct(Product productToReceive) {
		super();
		this.productToReceive = productToReceive;
	}

}
