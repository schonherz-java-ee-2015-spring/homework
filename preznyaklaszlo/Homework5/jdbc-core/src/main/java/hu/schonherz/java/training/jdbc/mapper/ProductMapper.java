package hu.schonherz.java.training.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.java.training.jdbc.records.Product;

public class ProductMapper implements RowMapper<Product> {

	public ProductMapper() {
		super();
	}

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product(rs.getInt("id"), rs.getInt("price"), rs.getString("name"));
		return product;
	}

}
