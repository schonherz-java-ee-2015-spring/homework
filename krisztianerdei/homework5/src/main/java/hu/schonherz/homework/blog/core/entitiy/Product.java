package hu.schonherz.homework.blog.core.entitiy;

import java.io.Serializable;

public class Product implements Serializable {
	// product class with the setters , getters , etc...
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	private static final long serialVersionUID = 4622759659488160394L;

	Integer id = null;
	String name;
	int price;

	public Product(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
