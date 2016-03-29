package hu.schonherz.homework.webshop.dao;

import hu.schonherz.homework.webshop.dto.Order;

public interface OrderDao {

	boolean addOrder(Order order);
	
	boolean addOrder(int userId, int productId);
}
