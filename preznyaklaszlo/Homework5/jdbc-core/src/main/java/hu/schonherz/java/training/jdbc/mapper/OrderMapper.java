package hu.schonherz.java.training.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.java.training.jdbc.records.Order;

public class OrderMapper implements RowMapper<Order> {

	public OrderMapper() {
		super();
	}

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order(rs.getInt("user_id"), rs.getInt("product_id"));
		return order;
	}

}
