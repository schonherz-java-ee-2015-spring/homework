package hu.schonherz.java.training.jdbc.dao;

import java.util.List;

import hu.schonherz.java.training.jdbc.records.Order;

public interface OrderDao {

	public List<Order> getAllOrders();

	public void addOrder(Order order);

	public void deleteOrder(Order order);

}
