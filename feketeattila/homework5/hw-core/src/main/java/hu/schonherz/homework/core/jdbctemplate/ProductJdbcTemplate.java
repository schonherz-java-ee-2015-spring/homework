package hu.schonherz.homework.core.jdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.core.dao.Dao;
import hu.schonherz.homework.core.dto.ProductDto;
import hu.schonherz.homework.core.mapper.ProductRowMapper;

@Repository
public class ProductJdbcTemplate extends JdbcDaoSupport implements Dao<ProductDto> {

	@Autowired
	public ProductJdbcTemplate(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public void addElement(ProductDto product) {
		String sql = "INSERT INTO public.\"Product\" (name, price) VALUES (?,?) ;";
		getJdbcTemplate().update(sql, product.getName(), product.getPrice());
	}

	@Override
	public void updateElement(ProductDto product) {
		String sql = "UPDATE public.\"Product\" SET name = ? , price = ? WHERE id = ? ;";
		getJdbcTemplate().update(sql, product.getName(), product.getPrice(), product.getId());

	}

	@Override
	public void deleteElement(ProductDto product) {
		String sql = "DELETE FROM public.\"Product\" WHERE id = ? , name = ? , price = ? ;";
		getJdbcTemplate().update(sql, product.getId(), product.getName(), product.getPrice());
	}

	@Override
	public List<ProductDto> getAllElements() {
		String sql = "SELECT * FROM public.\"Product\" ;";
		return getJdbcTemplate().query(sql, new ProductRowMapper());
	}

	@Override
	public ProductDto getElementById(Long id) {
		String sql = "SELECT * FROM public.\"Product\" WHERE id = ? ;";
		return getJdbcTemplate().queryForObject(sql, new ProductRowMapper(), id);
	}
}
