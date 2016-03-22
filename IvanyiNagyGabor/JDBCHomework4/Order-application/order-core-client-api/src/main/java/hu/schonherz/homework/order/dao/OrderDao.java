package hu.schonherz.homework.order.dao;

import java.util.List;

import hu.schonherz.homework.order.dto.Order;

public interface OrderDao {

	public List<Order> getAllOrders();

	public List<Order> getOrdersByUserId(Integer id);
	
	public List<Order> getOrdersByProductId(Integer id);
	
	public void addOrder(Order order);

	public void updateOrder(Order oldOrder, Order newOrder);

	public void deleteOrder(Order order);
}
