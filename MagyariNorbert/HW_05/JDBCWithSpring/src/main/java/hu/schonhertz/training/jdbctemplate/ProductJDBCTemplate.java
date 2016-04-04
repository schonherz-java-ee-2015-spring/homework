package hu.schonhertz.training.jdbctemplate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import hu.schonhertz.training.dao.ProductDao;
import hu.schonhertz.training.mapper.ProductMapper;
import hu.schonhertz.training.pojo.Product;

public class ProductJDBCTemplate implements ProductDao {

	
	 private JdbcTemplate jdbcTemplate;
	 
	  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		    this.jdbcTemplate = jdbcTemplate;
		  }
	
	@Override
	public List<Product> getAllProduct() {
	    String sql = "SELECT name, id, price FROM public.\"Product\";";
	    List<Product> product = jdbcTemplate.query(sql, new ProductMapper());
		return product;
	}

	@Override
	public Product getProductById(Long id) {
	    String sql = "SELECT name, id, price FROM public.\"Product\" WHERE id = ?;";
	    Product product = jdbcTemplate.queryForObject(sql, new ProductMapper(), id);
		return product;
	}

	@Override
	public void createProduct(String name, Integer price, Long id) {
	    String sql = "INSERT INTO public.\"Product\"(name, price) VALUES (?, ?);";
	    jdbcTemplate.update(sql, name, price);

	}
	
	@Override
	public void deleteProduct(String name) {
		    String sql = "DELETE FROM public.\"Product\" WHERE name=?;";
		    jdbcTemplate.update(sql, name);
	}

}
