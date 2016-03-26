package hu.schonherz.training.hw.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonherz.training.hw.spring.dao.OrderDAO;
import hu.schonherz.training.hw.spring.dto.Order;
import hu.schonherz.training.hw.spring.dto.User;
import hu.schonherz.training.hw.spring.mapper.OrderMapper;

@Repository
public class OrderDaoImpl extends JdbcDaoSupport implements OrderDAO {

	@Autowired
	public OrderDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public void addOrder(Integer userId, Integer productId) {
		String sql = "INSERT INTO public.\"Order\" (user_id,product_id) VALUES (?,?);";
		getJdbcTemplate().update(sql, userId, productId);
	}

	@Override
	public void updateOrder(Order order) {
		String sql = "UPDATE public.\"Order\" SET user_id = ? , product_id = ? WHERE id = ? ;";
		getJdbcTemplate().update(sql, order.getId(), order.getUserId(), order.getProductId());
	}

	@Override
	public void deleteOrder(Integer oId) {
		String sql = "DELETE FROM public.\"Order\" WHERE id = ?;";
		getJdbcTemplate().update(sql, oId);
	}

	@Override
	public Order getOrderById(Integer oId) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE id = ?;";
		Order order = getJdbcTemplate().queryForObject(sql, new OrderMapper(), oId);
		return order;
	}

	@Override
	public List<Order> getOrdersByUser(User user) {
		List<Order> uorders = new ArrayList<>();
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE user_id = ?;";
		uorders = getJdbcTemplate().query(sql, new OrderMapper(), user.getId());
		return uorders;
	}

	@Override
	public List<Order> getAllOrders() {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\";";
		List<Order> orders = getJdbcTemplate().query(sql, new OrderMapper());
		return orders;
	}
}
