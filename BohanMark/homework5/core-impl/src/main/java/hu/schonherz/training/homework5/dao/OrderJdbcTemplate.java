package hu.schonherz.training.homework5.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import hu.schonherz.training.homework5.mapper.OrderMapper;
import hu.schonherz.training.homework5.pojo.Order;

/**
 * dao for orders
 * 
 * @author Mark Bohan
 *
 */
public class OrderJdbcTemplate implements OrderDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * sets the dataSource
	 * 
	 * @param dataSource
	 *            the new dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}
	public OrderJdbcTemplate(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public Order findOrderById(Integer id) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE id = ?";
		Order order = jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new OrderMapper());

		return order;
	}

	@Override
	public List<Order> findOrdersByUserId(Integer userId) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE user_id = ?";
		List<Order> orders = jdbcTemplateObject.query(sql, new Object[] { userId }, new OrderMapper());
		return orders;
	}

	@Override
	public List<Order> findOrdersByProductId(Integer productId) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE product_id = ?";
		List<Order> orders = jdbcTemplateObject.query(sql, new Object[] { productId }, new OrderMapper());
		return orders;
	}

	@Override
	public List<Order> findOrdersByUserIdAndProductId(Integer userId, Integer productId) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE product_id = ? AND user_id = ?";
		List<Order> orders = jdbcTemplateObject.query(sql, new Object[] { productId, userId }, new OrderMapper());
		return orders;
	}

	@Override
	public List<Order> getAllOrders() {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\"";
		List<Order> orders = jdbcTemplateObject.query(sql, new OrderMapper());
		return orders;
	}

	@Override
	public void createOrder(Integer userId, Integer productId) {
		String sql = "INSERT INTO public.\"Order\"(user_id, product_id) VALUES ( ? , ? );";
		jdbcTemplateObject.update(sql, userId, productId);
	}

}
