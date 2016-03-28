package hu.schonherz.homework.order.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.order.dto.ProductDto;

public class ProductRowMapper implements RowMapper<ProductDto> {

	// Set and return the productDto from the resultSet
	public ProductDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		ProductDto productDto = new ProductDto();
		productDto.setId(resultSet.getLong("id"));
		productDto.setName(resultSet.getString("name"));
		productDto.setPrice(resultSet.getLong("price"));
		return productDto;
	}

}
