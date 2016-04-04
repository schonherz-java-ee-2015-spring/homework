package hu.schonherz.homework.blog.core.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.blog.core.entitiy.Product;
import hu.schonherz.homework.blog.core.mapper.ProductMapper;
import hu.schonherz.homework.blog.core.repository.ProductDao;

@Repository
public class ProductJDBCTemplate implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Product> getAllProduct() {

		String sql = "SELECT id, name , price FROM public.\"Product\";";
		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
		return products;

	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(String name, int price) {
		String sql = "INSERT INTO public.\"Product\"(name, price) VALUES (?, ?);";
		jdbcTemplate.update(sql, name, price);
	}

	@Override
	public void addProduct(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductName(int id, String newName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductPrice(int id, int newPrice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getProductsByCall() {
		// TODO Auto-generated method stub

	}

}
