package hu.schonherz.homework.headswitcher.order;

import java.util.List;

public interface OrderDao {
	
	// Dao interface
	
	public List<Order> getAllProduct();

	public Order getOrderByUser_Id(int userId);

	public Order getOrderByProduct_Id(int productId);

	public void addOrder(int userid, int productid);

	public void deleteOrderByUser_Id(int userid);

	public void deleteOrderByProduct_Id(int productid);

	public void updateUserOrder(int user_Id, int newProductId);

}
