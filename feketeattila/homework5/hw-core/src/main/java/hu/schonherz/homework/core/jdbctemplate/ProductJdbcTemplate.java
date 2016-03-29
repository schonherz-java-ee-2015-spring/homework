package hu.schonherz.homework.core.jdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.core.dao.Dao;
import hu.schonherz.homework.core.dto.ProductDto;
import hu.schonherz.homework.core.mapper.ProductRowMapper;

@Repository
public class ProductJdbcTemplate implements Dao<ProductDto> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addElement(ProductDto product) {
		String sql = "INSERT INTO public.\"Product\" (name, price) VALUES (?,?) ;";
		jdbcTemplate.update(sql, product.getName(), product.getPrice());
	}

	@Override
	public void updateElement(ProductDto product) {
		String sql = "UPDATE public.\"Product\" SET name = ? , price = ? WHERE id = ? ;";
		jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getId());

	}

	@Override
	public void deleteElement(ProductDto product) {
		String sql = "DELETE FROM public.\"Product\" WHERE id = ? , name = ? , price = ? ;";
		jdbcTemplate.update(sql, product.getId(), product.getName(), product.getPrice());
	}

	@Override
	public List<ProductDto> getAllElements() {
		String sql = "SELECT * FROM public.\"Product\" ;";
		return jdbcTemplate.query(sql, new ProductRowMapper());
	}

	@Override
	public ProductDto getElementById(Long id) {
		String sql = "SELECT * FROM public.\"Product\" WHERE id = ? ;";
		return jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);
	}
}
