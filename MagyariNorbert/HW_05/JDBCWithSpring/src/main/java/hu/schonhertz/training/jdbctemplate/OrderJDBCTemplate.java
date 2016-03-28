package hu.schonhertz.training.jdbctemplate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import hu.schonhertz.training.dao.OrderDao;
import hu.schonhertz.training.mapper.OrderMapper;
import hu.schonhertz.training.pojo.Order;

public class OrderJDBCTemplate implements OrderDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Order> getAllOrder() {
	    String sql = "SELECT user_id, product_id FROM public.\"Order\";";
	    List<Order> order = jdbcTemplate.query(sql, new OrderMapper());
		return order;
	}

	@Override
	public List<Order> getOrderByProductId(Long id) {
	    String sql = "SELECT user_id, product_id FROM public.\"Order\" WHERE product_id = ?;";
	    List<Order> order = jdbcTemplate.query(sql, new OrderMapper(), id);
		return order;
	}

	@Override
	public List<Order> getOrderByUserId(Long id) {
	    String sql = "SELECT user_id, product_id FROM public.\"Order\" WHERE user_id = ?;";
	    List<Order> order = jdbcTemplate.query(sql, new OrderMapper(), id);
		return order;
	}

	@Override
	public void createOrder(Long user_id, Long product_id) {
	    String sql = "INSERT INTO public.\"Order\"(user_id, product_id) VALUES (?, ?);";
	    jdbcTemplate.update(sql, user_id, product_id);

	}

	public void deleteOrderByUserId(Long user_id) {
	    String sql = "DELETE FROM public.\"Order\" WHERE user_id=?;";
	    jdbcTemplate.update(sql, user_id);
	}

}
