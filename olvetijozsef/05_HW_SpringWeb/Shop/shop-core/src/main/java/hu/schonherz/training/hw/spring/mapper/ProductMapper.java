package hu.schonherz.training.hw.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.training.hw.spring.dto.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		return product;
	}

}
