package hu.schonherz.training.dao;

import java.util.List;

import hu.schonherz.training.pojo.Order;
import hu.schonherz.training.pojo.Product;
import hu.schonherz.training.pojo.User;

public interface OrderDao {

	public List<Order> getAllOrder();
	
	public List<User> getAllUser();
	
	public List<Product> getAllProduct();

	public void createOrder(int userId, int productId);
	
	public void removeOrderByUserId(int userId);
}
