package hu.schonherz.homework.blog.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.blog.core.entitiy.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order(rs.getInt("user_id"), rs.getInt("product_id"));
		return order;
	}

}
