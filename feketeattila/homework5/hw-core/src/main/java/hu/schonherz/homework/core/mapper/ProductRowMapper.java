package hu.schonherz.homework.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.core.dto.ProductDto;

public class ProductRowMapper implements RowMapper<ProductDto> {

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ProductDto(rs.getLong("id"), rs.getString("name"), rs.getLong("price"));
	}

}
