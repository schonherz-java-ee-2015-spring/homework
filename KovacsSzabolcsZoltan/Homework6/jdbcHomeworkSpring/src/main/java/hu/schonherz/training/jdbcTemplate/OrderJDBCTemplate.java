package hu.schonherz.training.jdbcTemplate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import hu.schonherz.training.dao.OrderDao;
import hu.schonherz.training.mapper.OrderMapper;
import hu.schonherz.training.mapper.ProductMapper;
import hu.schonherz.training.mapper.UserMapper;
import hu.schonherz.training.pojo.Order;
import hu.schonherz.training.pojo.Product;
import hu.schonherz.training.pojo.User;

public class OrderJDBCTemplate implements OrderDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Order> getAllOrder() {
		String sql = "SELECT user_id, product_id FROM public.\"Order\";";
		List<Order> order = jdbcTemplate.query(sql, new OrderMapper());
		return order;
	}

	public void createOrder(int userId, int productId) {
		String sql = "INSERT INTO public.\"Order\"(user_id, product_id) VALUES (?, ?);";
	    jdbcTemplate.update(sql, userId, productId);
	}

	public void removeOrderByUserId(int userId) {
		String sql = "DELETE FROM public.\"Order\" WHERE user_id LIKE ?;";
		jdbcTemplate.update(sql);
	}

	@Override
	public List<User> getAllUser() {
		String sql = "SELECT id, name FROM public.\"User\";";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}
	
	@Override
	public List<Product> getAllProduct() {
		String sql = "SELECT id, name, price FROM public.\"Product\";";
		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
		return products;
	}


}
