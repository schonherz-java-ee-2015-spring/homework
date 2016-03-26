package hu.schonherz.training.hw.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonherz.training.hw.spring.dao.UserDAO;
import hu.schonherz.training.hw.spring.dto.User;
import hu.schonherz.training.hw.spring.mapper.UserMapper;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDAO {

	@Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public void addUser(String userName) {
		String sql = "INSERT INTO public.\"User\" (name) VALUES (?);";
		getJdbcTemplate().update(sql, userName);
	}

	@Override
	public void updateUser(User user) {
		String sql = "UPDATE public.\"User\" SET name = ? WHERE id = ? ;";
		getJdbcTemplate().update(sql, user.getName(), user.getId());
	}

	@Override
	public void deleteUser(Integer userId) {
		String sql = "DELETE FROM public.\"User\" WHERE id = ?;";
		getJdbcTemplate().update(sql, userId);
	}

	@Override
	public User getUserById(Integer userId) {
		String sql = "SELECT id, name FROM public.\"User\" WHERE id = ?;";
		User user = getJdbcTemplate().queryForObject(sql, new UserMapper(), userId);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT id, name FROM public.\"User\";";
		List<User> users = getJdbcTemplate().query(sql, new UserMapper());
		return users;
	}

}
