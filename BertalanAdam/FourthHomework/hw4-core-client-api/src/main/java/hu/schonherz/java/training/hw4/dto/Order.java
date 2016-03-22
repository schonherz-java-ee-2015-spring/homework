package hu.schonherz.java.training.hw4.dto;

public class Order {

	private int user_id;
	private int product_id;

	public Order(int user_id, int product_id) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id
	 *            the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [user_id=" + user_id + ", product_id=" + product_id + "]";
	}
}
