package hu.schonherz.homework.core.jdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.core.dao.Dao;
import hu.schonherz.homework.core.dto.UserDto;
import hu.schonherz.homework.core.mapper.UserRowMapper;

@Repository
public class UserJdbcTemplate extends JdbcDaoSupport implements Dao<UserDto> {

	@Autowired
	public UserJdbcTemplate(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public void addElement(UserDto user) {
		String sql = "INSERT INTO public.\"User\" (name) VALUES (?) ;";
		getJdbcTemplate().update(sql, user.getName());
	}

	@Override
	public void updateElement(UserDto user) {
		String sql = "UPDATE public.\"User\" SET name = ? WHERE id = ? ;";
		getJdbcTemplate().update(sql, user.getName(), user.getId());
	}

	@Override
	public void deleteElement(UserDto user) {
		String sql = "DELETE FROM public.\"User\" WHERE id = ? , name = ? ;";
		getJdbcTemplate().update(sql, user.getId(), user.getName());
	}

	@Override
	public List<UserDto> getAllElements() {
		String sql = "SELECT * FROM public.\"User\" ;";
		return getJdbcTemplate().query(sql, new UserRowMapper());
	}

	@Override
	public UserDto getElementById(Long id) {
		String sql = "SELECT * FROM public.\"User\" WHERE id = ? ;";
		return getJdbcTemplate().queryForObject(sql, new UserRowMapper(), id);
	}
}
