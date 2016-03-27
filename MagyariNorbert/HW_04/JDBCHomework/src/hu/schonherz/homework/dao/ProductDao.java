package hu.schonherz.homework.dao;

import java.util.List;
import hu.schonherz.homework.records.Product;

public interface ProductDao {

	public List<Product> getAllProduct();

	public Product getProductByName(String name);

	public void addProduct(String name, int price);

	public void updateProductById(Product product);

	public void deleteProductByNameAndId(String name, int id);
}
