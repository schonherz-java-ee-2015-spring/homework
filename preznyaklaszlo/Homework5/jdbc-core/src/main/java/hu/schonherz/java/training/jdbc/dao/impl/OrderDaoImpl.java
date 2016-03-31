package hu.schonherz.java.training.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.java.training.jdbc.dao.OrderDao;
import hu.schonherz.java.training.jdbc.mapper.OrderMapper;
import hu.schonherz.java.training.jdbc.records.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = jdbcTemplate.query("SELECT * FROM public.\"Order\"", new OrderMapper());
		return orders;
	}

	@Override
	public boolean addOrder(Order order) {
		return addOrder(order.getUserId(), order.getProductId());
	}

	@Override
	public boolean addOrder(int userId, int productId) {
		if (jdbcTemplate.update("INSERT INTO public.\"Order\" (user_id, product_id) VALUES (?,?);", userId,
				productId) != 0) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean deleteOrder(int userId, int productId) {
		if (jdbcTemplate.update("DELETE FROM public.\"Order\" WHERE user_id=? AND product_id=?;", userId,
				productId) != 0) {
			return true;
		} else
			return false;

	}

	@Override
	public boolean deleteOrder(Order order) {
		return deleteOrder(order.getUserId(), order.getProductId());
	}

}
