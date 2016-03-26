package hu.schonherz.java.training.jdbc.dao;

import java.util.List;

import hu.schonherz.java.training.jdbc.records.Product;

public interface ProductDao {

	public Product getProductByName(String name);

	public List<Product> getAllProducts();

	public void addProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);
}
