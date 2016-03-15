package orderProduct;

public class OrderProduct implements Order {

	private Product productToOrder;

	public void execute() {
		productToOrder.order();
	}

	public OrderProduct(Product productToOrder) {
		super();
		this.productToOrder = productToOrder;
	}

}
