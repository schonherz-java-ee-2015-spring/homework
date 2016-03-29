package hu.schonherz.homework.webshop.vo;

import java.io.Serializable;

public class ProductVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5139035779856180508L;

	private int id;
	private int price;
	private String name;
	
	public ProductVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ProductVO [ID: " + id + ", price: " + price + ", name: " + name + "].";
	}
}
