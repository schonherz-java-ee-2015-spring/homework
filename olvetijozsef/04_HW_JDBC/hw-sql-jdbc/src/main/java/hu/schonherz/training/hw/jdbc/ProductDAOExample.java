package hu.schonherz.training.hw.jdbc;

import java.util.List;

import hu.schonherz.training.hw.jdbc.dao.ProductDAO;
import hu.schonherz.training.hw.jdbc.dao.impl.ProductDAOImpl;
import hu.schonherz.training.hw.jdbc.entity.Product;

public class ProductDAOExample {
	public static void main(String[] args) {
		ProductDAO pdao = new ProductDAOImpl();

		Product product = new Product(0, "Termék", 100);
		pdao.addProduct(product);
		System.out.println(product.getId() + " - " + product.getName() + " - " + product.getPrice() + " added.");

		productLister(pdao);

		product.setName("Rossz termék");
		pdao.updateProduct(product);
		System.out.println(product.getId() + " updated.");

		productLister(pdao);

		pdao.deleteProduct(product);
		System.out.println(product.getId() + " - " + product.getName() + " - " + product.getPrice() + " deleted.");

		productLister(pdao);
	}

	private static void productLister(ProductDAO pdao) {
		List<Product> products = pdao.getAllProducts();
		System.out.println("Products");
		for (Product p : products) {
			System.out.println(p.getId() + " - " + p.getName() + " - " + p.getPrice());
		}
		System.out.println("----");
	}
}
