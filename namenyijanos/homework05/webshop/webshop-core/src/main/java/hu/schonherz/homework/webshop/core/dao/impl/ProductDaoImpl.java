package hu.schonherz.homework.webshop.core.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.webshop.core.dao.mapper.ProductMapper;
import hu.schonherz.homework.webshop.dao.ProductDao;
import hu.schonherz.homework.webshop.dto.Product;


@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean addProduct(Product product) {
		return addProduct(product.getPrice(), product.getName());
	}

	public boolean addProduct(int price, String name) {
		int result = jdbcTemplate.update("INSERT INTO public.\"Product\" (price, name) VALUES (?,?);", price,  name);
		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}

	public List<Product> getAllProducts() {
		List<Product> products = null;
		products = jdbcTemplate.query("SELECT * FROM public.\"Product\";", new ProductMapper() );
		return products;
	}

}
