package hu.schonherz.homework.order.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.order.dao.ProductDao;
import hu.schonherz.homework.order.dto.ProductDto;
import hu.schonherz.homework.order.mapper.ProductRowMapper;

@Repository
public class ProductDaoImpl extends JdbcDaoSupport implements ProductDao {

	@Autowired
	public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	// Insert product into the Product table
	public void save(ProductDto dto) throws Exception {
		String sql = "INSERT INTO public.\"Product\"(name, price) VALUES (?, ?);";
		getJdbcTemplate().update(sql, dto.getName(), dto.getPrice());
	}

	// Update productDto
	public void update(ProductDto dto) throws Exception {
		String sql = "UPDATE public.\"Product\" SET name=?, pric=? WHERE id=?;";
		getJdbcTemplate().update(sql, dto.getName(), dto.getPrice(), dto.getId());
	}

	// Delete productDto by id
	public void delete(Long id) throws Exception {
		String sql = "DELETE FROM public.\"Product\" WHERE id=?;";
		getJdbcTemplate().update(sql, id);
	}

	// return product by id
	public ProductDto find(Long id) throws Exception {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE id = ?;";
		ProductDto product = getJdbcTemplate().queryForObject(sql, new ProductRowMapper(), id);
		return product;
	}

	// Return all product
	public List<ProductDto> findAll() throws Exception {
		String sql = "SELECT id, name, price FROM public.\"Product\";";
		List<ProductDto> productDtos = getJdbcTemplate().query(sql, new ProductRowMapper());
		return productDtos;
	}

}
