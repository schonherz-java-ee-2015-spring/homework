package hu.schonherz.training.hw.jdbc.dao;

import java.util.List;

import hu.schonherz.training.hw.jdbc.entity.Order;
import hu.schonherz.training.hw.jdbc.entity.User;

public interface OrderDAO {

	public void addOrder(Order order);

	public void updateOrder(Order order);

	public void deleteOrder(Order order);

	public Order getOrderById(int id);

	public List<Order> getOrdersByUser(User user);

	public List<Order> getAllOrders();

}
