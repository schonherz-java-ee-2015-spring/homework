package hu.schonherz.homework.order.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.order.dao.UserDao;
import hu.schonherz.homework.order.dto.UserDto;
import hu.schonherz.homework.order.mapper.UserRowMapper;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	@Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	public void save(UserDto dto) throws Exception {
		String sql = "INSERT INTO public.\"User\"(name) VALUES (?);";
		getJdbcTemplate().update(sql, dto.getName());
	}

	public void update(UserDto dto) throws Exception {
		String sql = "UPDATE public.\"User\" SET name=? WHERE id=?;";
		getJdbcTemplate().update(sql, dto.getName(), dto.getId());
	}

	public void delete(Long id) throws Exception {
		String sql = "DELETE FROM public.\"User\" WHERE id=?;";
		getJdbcTemplate().update(sql, id);
	}

	public UserDto find(Long id) throws Exception {
		String sql = "SELECT id, name FROM public.\"User\" WHERE id = ?;";
		UserDto user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), id);
		return user;
	}

	public List<UserDto> findAll() throws Exception {
		String sql = "SELECT id, name FROM public.\"User\";";
		List<UserDto> userDtos = getJdbcTemplate().query(sql, new UserRowMapper());
		return userDtos;
	}

}
