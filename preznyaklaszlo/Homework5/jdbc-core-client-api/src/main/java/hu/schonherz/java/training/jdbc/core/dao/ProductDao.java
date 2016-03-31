package hu.schonherz.java.training.jdbc.core.dao;

import java.util.List;

import hu.schonherz.java.training.jdbc.core.records.Product;

public interface ProductDao {

	public List<Product> getAllProducts();

	public void addProduct(Product product);

}
