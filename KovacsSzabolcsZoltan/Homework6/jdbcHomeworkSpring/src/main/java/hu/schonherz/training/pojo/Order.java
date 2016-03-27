package hu.schonherz.training.pojo;

public class Order {
	
	private int userId;
	private int productId;
	
	public Order(int userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int user_id) {
		this.userId = user_id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int product_id) {
		this.productId = product_id;
	}
	@Override
	public String toString() {
		return "userId = " + userId + "| productId = " + productId;
	}
	
	
}
