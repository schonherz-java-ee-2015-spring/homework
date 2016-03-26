package hu.schonherz.homework.headswitcher.product;

public class ProductWuId {
	String name;
	int price;
	@Override
	public String toString() {
		return "ProductWuId [name=" + name + ", price=" + price + "]";
	}
	public ProductWuId(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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
