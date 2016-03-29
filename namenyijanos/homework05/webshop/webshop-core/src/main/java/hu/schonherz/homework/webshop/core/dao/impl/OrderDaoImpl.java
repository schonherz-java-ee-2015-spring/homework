package hu.schonherz.homework.webshop.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.webshop.dao.OrderDao;
import hu.schonherz.homework.webshop.dto.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean addOrder(Order order) {
		return addOrder( order.getUserId(), order.getProductId());
	}

	public boolean addOrder(int userId, int productId) {
		int result = jdbcTemplate.update("INSERT INTO public.\"Order\" (user_id, product_id) VALUES (?,?);", userId, productId);
		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}

}
