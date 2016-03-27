package hu.schonherz.homework.records;

public class Order {

	private int productId;
	private int userId;

	public Order(int productId, int userId) {
		super();
		this.productId = productId;
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [productId=" + productId + ", userId=" + userId + "]";
	}



}
