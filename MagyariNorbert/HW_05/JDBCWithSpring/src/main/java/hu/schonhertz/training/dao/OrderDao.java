package hu.schonhertz.training.dao;

import java.util.List;

import hu.schonhertz.training.pojo.Order;

public interface OrderDao {
	
	  public List<Order> getAllOrder();
	  
	  public List<Order> getOrderByProductId(Long id);
	  
	  public List<Order> getOrderByUserId(Long id);
	  
	  public void createOrder(Long user_id, Long product_id);

}
