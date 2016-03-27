package hu.schonherz.homework.order.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.order.dao.OrderDao;
import hu.schonherz.homework.order.dto.OrderDto;
import hu.schonherz.homework.order.mapper.OrderRowMapper;

@Repository
public class OrderDaoImpl extends JdbcDaoSupport implements OrderDao {

	@Autowired
	public OrderDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	public void save(OrderDto dto) throws Exception {
		String sql = "INSERT INTO public.\"Order\"(user_id, product_id) VALUES (?, ?);";
		getJdbcTemplate().update(sql, dto.getUserId(), dto.getProductId());
	}

	public void update(OrderDto oldDto, OrderDto newDto) throws Exception {
		String sql = "UPDATE public.\"Order\" SET user_id=?, product_id=? WHERE user_id=? and product_id=?;";
		getJdbcTemplate().update(sql, newDto.getUserId(), newDto.getProductId(), oldDto.getUserId(), oldDto.getProductId());
	}

	public void delete(OrderDto dto) throws Exception {
		String sql = "DELETE FROM public.\"Order\" WHERE user_id=? and product_id=?;";
		getJdbcTemplate().update(sql, dto.getUserId(), dto.getProductId());
	}

	public List<OrderDto> find(Long userId) throws Exception {
		String sql = "SELECT user_id, product_id FROM public.\"Order\" WHERE user_id = ?;";
		List<OrderDto> orderDtos = getJdbcTemplate().query(sql, new OrderRowMapper(), userId);
		return orderDtos;
	}

	public List<OrderDto> findAll() throws Exception {
		String sql = "SELECT user_id, product_id FROM public.\"Order\";";
		List<OrderDto> orderDtos = getJdbcTemplate().query(sql, new OrderRowMapper());
		return orderDtos;
	}

}
