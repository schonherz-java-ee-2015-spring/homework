package hu.schonherz.training.homework5.dao;

import java.util.List;

import hu.schonherz.training.homework5.pojo.Product;

/**
 * Data Access Object for products
 * 
 * @author Mark Bohan
 *
 */
public interface ProductDao {
	/**
	 * finds the product by it's id
	 * 
	 * @param id
	 *            the id of product
	 * @return the found product
	 */
	public Product findProductById(Integer id);

	/**
	 * finds the product by it's name
	 * 
	 * @param name
	 *            the name of product
	 * @return the found product
	 */
	public Product findProductByName(String name);

	/**
	 * returns all products
	 * 
	 * @return the list of all products
	 */
	public List<Product> getAllProducts();

	/**
	 * creates a product
	 * 
	 * @param product
	 *            the product to create
	 */
	public void createProduct(Product product);

}
