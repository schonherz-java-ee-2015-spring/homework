package hu.schonherz.homework.blog.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.blog.core.entitiy.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product(rs.getInt("id"),rs.getString("name"),rs.getInt("price"));	
		return product;
	}

}
