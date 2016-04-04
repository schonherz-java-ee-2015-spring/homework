package hu.schonherz.training.homework5.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import hu.schonherz.training.homework5.mapper.ProductMapper;
import hu.schonherz.training.homework5.pojo.Product;

/**
 * dao for products
 * 
 * @author Mark Bohan
 *
 */
public class ProductJdbcTemplate implements ProductDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * sets the dataSource
	 * 
	 * @param dataSource
	 *            the new dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

	public ProductJdbcTemplate(DataSource dataSource) {
		setDataSource(dataSource);
	}
	@Override
	public Product findProductById(Integer id) {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE id = ?";
		Product product = jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new ProductMapper());
		return product;
	}

	@Override
	public Product findProductByName(String name) {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE name = ?";
		Product product = jdbcTemplateObject.queryForObject(sql, new Object[] { name }, new ProductMapper());

		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		String sql = "select * from public.\"Product\"";
		List<Product> products = jdbcTemplateObject.query(sql, new ProductMapper());
		return products;
	}

	@Override
	public void createProduct(Product product) {
		String sql = "INSERT INTO public.\"Product\"(name, price) VALUES ( ? , ? );";

		jdbcTemplateObject.update(sql, product.getName(), product.getPrice());
	}

}
