package hu.schonherz.homework.order.dto;

public class Order {

	private Integer user_id;
	private Integer product_id;

	public Order() {
		super();
	}

	public Order(Integer user_id, Integer product_id) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "Order [user_id=" + user_id + ", product_id=" + product_id + "]";
	}

}
