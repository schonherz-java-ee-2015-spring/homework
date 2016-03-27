package hu.schonherz.training.homework4.batch;

import java.util.List;

import hu.schonherz.training.homework4.dto.Product;

/**
 * Products insertion and deletion
 * 
 * @author Mark Bohan
 *
 */
public interface ProductBatch {

	/**
	 * insert a list of products
	 * 
	 * @param products
	 *            list of products to insert
	 * @return size of inserted products
	 */
	public int insertProducts(List<Product> products);

	/**
	 * delete a list of products
	 * 
	 * @param productIds
	 *            list of id of products to delete
	 * @return size of deleted products
	 */
	public int deleteProducts(List<Integer> productIds);
}
