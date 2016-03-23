package hu.schonherz.homework.records;

public class Order {
	
	private int userId;
	private int productId;
	
	public Order(int userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String toString() {
		return userId + ":" + productId;
	}

}
