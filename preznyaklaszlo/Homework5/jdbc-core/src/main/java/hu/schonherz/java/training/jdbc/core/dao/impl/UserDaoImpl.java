package hu.schonherz.java.training.jdbc.core.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.java.training.jdbc.core.dao.UserDao;
import hu.schonherz.java.training.jdbc.core.mapper.UserMapper;
import hu.schonherz.java.training.jdbc.core.records.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		users = jdbcTemplate.query("SELECT id, name FROM public.\"User\";", new UserMapper());
		return users;
	}

	@Override
	public void addUser(User user) {
		jdbcTemplate.update("INSERT INTO public.\"User\" (name) VALUES (?);", user.getName());

	}

}
