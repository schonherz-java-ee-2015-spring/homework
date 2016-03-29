package hu.schonhertz.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonhertz.training.pojo.Order;

public class OrderMapper implements RowMapper<Order> {

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setProduct_id(rs.getLong("product_id"));
		order.setUser_id(rs.getLong("user_id"));
		return order;
	}
}
