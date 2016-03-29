package hu.schonherz.homework.core.jdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.core.dao.Dao;
import hu.schonherz.homework.core.dto.OrderDto;
import hu.schonherz.homework.core.mapper.OrderRowMapper;

@Repository
public class OrderJdbcTemplate implements Dao<OrderDto> {

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
	public void addElement(OrderDto order) {
		String sql = "INSERT INTO public.\"Order\" (product_id, user_id) VALUES (?,?) ;";
		jdbcTemplate.update(sql, order.getProductId(), order.getUserId());
	}

	@Override
	public void updateElement(OrderDto order) {
		String sql = "UPDATE public.\"Order\" SET product_id = ? WHERE user_id = ? ;";
		jdbcTemplate.update(sql, order.getProductId(), order.getUserId());
	}

	@Override
	public void deleteElement(OrderDto order) {
		String sql = "DELETE FROM public.\"Order\" WHERE product_id = ? , user_id = ? ;";
		jdbcTemplate.update(sql, order.getProductId(), order.getUserId());
	}

	@Override
	public List<OrderDto> getAllElements() {
		String sql = "SELECT * FROM public.\"Order\" ;";
		return jdbcTemplate.query(sql, new OrderRowMapper());
	}

	@Override
	public OrderDto getElementById(Long id) {
		String sql = "SELECT * FROM public.\"Order\" WHERE product_id = ? ;";
		return jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id);
	}
}
