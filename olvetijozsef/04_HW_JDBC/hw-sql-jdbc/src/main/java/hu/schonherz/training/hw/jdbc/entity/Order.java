package hu.schonherz.training.hw.jdbc.entity;

public class Order {
	private int id;
	private int userId;
	private int productId;

	public Order(int id, int userId, int productId) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "id=" + id + ", user_id=" + userId + ", product_id=" + productId;
	}

}
