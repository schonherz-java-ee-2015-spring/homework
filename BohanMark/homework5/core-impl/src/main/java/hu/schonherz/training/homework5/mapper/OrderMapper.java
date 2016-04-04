package hu.schonherz.training.homework5.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.training.homework5.pojo.Order;

/**
 * Mapper for orders
 * @author Mark Bohan
 *
 */
public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setId(rs.getInt("id"));
		order.setUserId(rs.getInt("user_id"));
		order.setProductId(rs.getInt("product_id"));
		return order;
	}

}
