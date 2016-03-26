package hu.schonherz.training.classes;

public class Order {
	
	private int userID;
	private int productID;
	
	public Order(int userID, int productID) {
		super();
		this.userID = userID;
		this.productID = productID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	@Override
	public String toString() {
		return "Order [userID=" + userID + ", productID=" + productID + "]";
	}
	
	
	
}
