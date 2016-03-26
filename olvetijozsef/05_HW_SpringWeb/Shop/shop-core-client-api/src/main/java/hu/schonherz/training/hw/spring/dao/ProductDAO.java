package hu.schonherz.training.hw.spring.dao;

import java.util.List;

import hu.schonherz.training.hw.spring.dto.Product;

public interface ProductDAO {

	void addProduct(String name, Double price);

	void updateProduct(Product product);

	void deleteProduct(Integer pId);

	Product getProductById(Integer pId);

	List<Product> getAllProducts();

}
