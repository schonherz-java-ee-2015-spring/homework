package hu.schonherz.java.training.jdbc.dao;

import java.util.List;

import hu.schonherz.java.training.jdbc.records.Product;

public interface ProductDao {

	public List<Product> getAllProducts();

	public void addProduct(Product product);

}
