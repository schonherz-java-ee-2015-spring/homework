package hu.schonherz.training.jdbcTemplate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import hu.schonherz.training.dao.ProductDao;
import hu.schonherz.training.mapper.ProductMapper;
import hu.schonherz.training.pojo.Product;

public class ProductJDBCTemplate implements ProductDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Product> getAllProduct() {
		String sql = "SELECT id, name, price FROM public.\"Product\";";
		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
		return products;
	}

	public Product getProductById(int id) {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE id = ?;";
		Product product = jdbcTemplate.queryForObject(sql, new ProductMapper(), id);
	    return product;
	}

	public void createProduct(String name, int price) {
		String sql = "INSERT INTO public.\"Product\"(name, price) VALUES (?, ?);";
	    jdbcTemplate.update(sql, name, price);
	}

	public void removeProduct(String name) {
		String sql = "DELETE FROM public.\"Product\" WHERE name LIKE ?;";
		jdbcTemplate.update(sql);
	}

}
