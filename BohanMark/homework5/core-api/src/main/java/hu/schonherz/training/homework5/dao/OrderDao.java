package hu.schonherz.training.homework5.dao;

import java.util.List;

import hu.schonherz.training.homework5.pojo.Order;

/**
 * Data Access Object for orders
 * 
 * @author Mark Bohan
 *
 */
public interface OrderDao {
	/**
	 * finds the order by it's id
	 * 
	 * @param id
	 *            the id of order
	 * @return the found order
	 */
	public Order findOrderById(Integer id);

	/**
	 * lists the orders of a user
	 * 
	 * @param userId
	 *            the id of the user
	 * @return the list of orders by user
	 */
	public List<Order> findOrdersByUserId(Integer userId);

	/**
	 * lists the orders of a product
	 * 
	 * @param productId
	 *            the id of a product
	 * @return the list of orders of products
	 */
	public List<Order> findOrdersByProductId(Integer productId);

	/**
	 * lists the orders of a user and a product
	 * 
	 * @param userId
	 *            the id of the user
	 * @param productId
	 *            the id of the product
	 * @return the list of orders of products by user
	 */
	public List<Order> findOrdersByUserIdAndProductId(Integer userId, Integer productId);

	/**
	 * returns all orders
	 * 
	 * @return the list of all orders
	 */
	public List<Order> getAllOrders();

	/**
	 * creates an order
	 * 
	 * @param userId
	 *            the id of the user
	 * @param productId
	 *            the id of the product
	 */
	public void createOrder(Integer userId, Integer productId);

}
