package hu.schonherz.training.hw.spring.dao;

import java.util.List;

import hu.schonherz.training.hw.spring.dto.Order;
import hu.schonherz.training.hw.spring.dto.User;

public interface OrderDAO {

	void addOrder(Integer userId, Integer productId);

	void updateOrder(Order order);

	void deleteOrder(Integer oId);

	Order getOrderById(Integer oId);

	List<Order> getOrdersByUser(User user);

	List<Order> getAllOrders();

}
