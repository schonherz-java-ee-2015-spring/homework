package hu.schonherz.training.hw.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.training.hw.spring.dto.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setId(rs.getInt("id"));
		order.setProductId(rs.getInt("product_id"));
		order.setUserId(rs.getInt("user_id"));
		return order;
	}

}
