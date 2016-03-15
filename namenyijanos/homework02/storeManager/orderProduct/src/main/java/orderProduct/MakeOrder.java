package orderProduct;

public class MakeOrder {

	public static void main(String[] args) {
		Product sampleProduct = new Product();

		OrderProduct orderSampleProduct = new OrderProduct(sampleProduct);
		ReceiveProduct receiveSampleProduct = new ReceiveProduct(sampleProduct);

		Purveyor purveyor = new Purveyor();
		purveyor.takeOrder(orderSampleProduct);
		purveyor.takeOrder(receiveSampleProduct);

		purveyor.placeOrders();
	}

}
