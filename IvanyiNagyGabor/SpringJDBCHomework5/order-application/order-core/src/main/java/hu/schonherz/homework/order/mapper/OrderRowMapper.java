package hu.schonherz.homework.order.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.order.dto.OrderDto;

public class OrderRowMapper implements RowMapper<OrderDto> {

	public OrderDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		OrderDto orderDto = new OrderDto();
		orderDto.setUserId(resultSet.getLong("user_id"));
		orderDto.setProductId(resultSet.getLong("product_id"));
		return orderDto;
	}

}
