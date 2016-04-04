package hu.schonherz.homework.core.jdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.core.dao.Dao;
import hu.schonherz.homework.core.dto.OrderDto;
import hu.schonherz.homework.core.mapper.OrderRowMapper;

@Repository
public class OrderJdbcTemplate extends JdbcDaoSupport implements Dao<OrderDto> {

	@Autowired
	public OrderJdbcTemplate(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public void addElement(OrderDto order) {
		String sql = "INSERT INTO public.\"Order\" (product_id, user_id) VALUES (?,?) ;";
		getJdbcTemplate().update(sql, order.getProductId(), order.getUserId());
	}

	@Override
	public void updateElement(OrderDto order) {
		String sql = "UPDATE public.\"Order\" SET product_id = ? WHERE user_id = ? ;";
		getJdbcTemplate().update(sql, order.getProductId(), order.getUserId());
	}

	@Override
	public void deleteElement(OrderDto order) {
		String sql = "DELETE FROM public.\"Order\" WHERE product_id = ? , user_id = ? ;";
		getJdbcTemplate().update(sql, order.getProductId(), order.getUserId());
	}

	@Override
	public List<OrderDto> getAllElements() {
		String sql = "SELECT * FROM public.\"Order\" ;";
		return getJdbcTemplate().query(sql, new OrderRowMapper());
	}

	@Override
	public OrderDto getElementById(Long id) {
		String sql = "SELECT * FROM public.\"Order\" WHERE product_id = ? ;";
		return getJdbcTemplate().queryForObject(sql, new OrderRowMapper(), id);
	}
}
