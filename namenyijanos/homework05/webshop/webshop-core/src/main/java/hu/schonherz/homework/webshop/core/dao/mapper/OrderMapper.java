package hu.schonherz.homework.webshop.core.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.webshop.dto.Order;

public class OrderMapper implements RowMapper<Order> {

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setUserId(rs.getInt("user_id"));
		order.setProductId(rs.getInt("product_id"));
		return order;
	}

}
