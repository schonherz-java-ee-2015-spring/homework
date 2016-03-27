package hu.schonherz.homework.dao;

import java.util.List;

import hu.schonherz.homework.records.Order;

public interface OrderDao {

	public List<Order> getAllOrder();
	
	public void addOrder(Order order);

	public void updateOrder(Order order);

	public void deleteOrder(Order order);
}
