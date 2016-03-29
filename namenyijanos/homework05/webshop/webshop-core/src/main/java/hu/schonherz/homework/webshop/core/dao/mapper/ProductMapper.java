package hu.schonherz.homework.webshop.core.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.webshop.dto.Product;

public class ProductMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setPrice(rs.getInt("price"));
		product.setName(rs.getString("name"));
		return product;
	}

}
