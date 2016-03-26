package hu.schonherz.training.hw.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonherz.training.hw.spring.dao.ProductDAO;
import hu.schonherz.training.hw.spring.dto.Product;
import hu.schonherz.training.hw.spring.mapper.ProductMapper;

@Repository
public class ProductDaoImpl extends JdbcDaoSupport implements ProductDAO {

	@Autowired
	public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public void addProduct(String name, Double price) {
		String sql = "INSERT INTO public.\"Product\" (name,price) VALUES (?,?);";
		getJdbcTemplate().update(sql, name, price);
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE public.\"Product\" SET name = ? , price = ? WHERE id = ? ;";
		getJdbcTemplate().update(sql, product.getName(), product.getPrice(), product.getId());
	}

	@Override
	public void deleteProduct(Integer pId) {
		String sql = "DELETE FROM public.\"Product\" WHERE id = ?;";
		getJdbcTemplate().update(sql, pId);
	}

	@Override
	public Product getProductById(Integer pId) {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE id = ?;";
		Product product = getJdbcTemplate().queryForObject(sql, new ProductMapper(), pId);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		String sql = "SELECT id, name, price FROM public.\"Product\";";
		List<Product> products = getJdbcTemplate().query(sql, new ProductMapper());
		return products;
	}

}
