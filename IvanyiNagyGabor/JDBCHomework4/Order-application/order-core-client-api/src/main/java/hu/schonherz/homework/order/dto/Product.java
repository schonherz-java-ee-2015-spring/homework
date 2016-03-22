package hu.schonherz.homework.order.dto;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = -3007176557337425169L;

	private Integer id;
	private String name;
	private Integer price;

	public Product() {
		super();
	}

	public Product(Integer id, String name, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
