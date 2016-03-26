package hu.schonherz.training.hw.spring.vo;

import java.io.Serializable;

public class ProductVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double price;

	public ProductVo() {
		super();
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVo [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
