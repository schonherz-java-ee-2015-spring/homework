package hu.schonherz.homework.dao;

import java.util.List;

import hu.schonherz.homework.records.Order;

public interface OrderDao {
	
	public List<Order> getAllOrders();
	
	public List<Order> getAllOrdersOfUser(int userId);

	public void addOrder(Order order);
	
	public void deleteOrder(Order order);

	public void deleteAllOrderOfUser(Order order);
}
