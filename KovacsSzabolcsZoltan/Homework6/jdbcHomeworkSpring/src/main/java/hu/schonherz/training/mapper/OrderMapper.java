package hu.schonherz.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.training.pojo.Order;

public class OrderMapper implements RowMapper<Order> {

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setProductId(rs.getInt("product_id"));
		order.setUserId(rs.getInt("user_id"));
		return order;
	}
}