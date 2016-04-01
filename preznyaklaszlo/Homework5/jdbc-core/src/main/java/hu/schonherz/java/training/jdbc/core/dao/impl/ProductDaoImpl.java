package hu.schonherz.java.training.jdbc.core.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.java.training.jdbc.core.dao.ProductDao;
import hu.schonherz.java.training.jdbc.core.mapper.ProductMapper;
import hu.schonherz.java.training.jdbc.core.records.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = null;
		products = jdbcTemplate.query("SELECT id, name FROM public.\"Product\";", new ProductMapper());
		return products;
	}

	@Override
	public void addProduct(Product product) {
		jdbcTemplate.update("INSERT INTO public.\"Product\" (price,name) VALUES (?,?);", product.getPrice(),
				product.getName());
	}

}
