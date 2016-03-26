package hu.schonherz.training.dao;

import java.util.List;

import hu.schonherz.training.classes.Order;

public interface OrderDao {

	public List<Order> getAllOrders();

//	public List<Integer> getProductIdByUserId(int user_id);
//
//	public List<Integer> getUserIdByProductId(int product_id);

	public void addOrder(Order order);

	public void updateOrder(Order order);

	public void deleteOrderByUserId(Integer user_id);

}
