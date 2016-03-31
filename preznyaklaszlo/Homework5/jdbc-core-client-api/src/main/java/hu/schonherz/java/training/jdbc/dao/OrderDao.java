package hu.schonherz.java.training.jdbc.dao;

import java.util.List;

import hu.schonherz.java.training.jdbc.records.Order;

public interface OrderDao {

	public List<Order> getAllOrders();

	public boolean addOrder(Order order);

	public boolean addOrder(int userId, int productId);

	public boolean deleteOrder(Order order);

	public boolean deleteOrder(int userId, int productId);

}
