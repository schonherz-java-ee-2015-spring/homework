package hu.schonherz.homework.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.core.dto.OrderDto;

public class OrderRowMapper implements RowMapper<OrderDto>{

	@Override
	public OrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new OrderDto(rs.getLong("product_id"), rs.getLong("user_id"));
	}

}
