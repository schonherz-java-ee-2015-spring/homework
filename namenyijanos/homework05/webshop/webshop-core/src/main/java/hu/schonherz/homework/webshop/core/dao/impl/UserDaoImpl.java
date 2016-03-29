package hu.schonherz.homework.webshop.core.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.webshop.core.dao.mapper.UserMapper;
import hu.schonherz.homework.webshop.dao.UserDao;
import hu.schonherz.homework.webshop.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean addUser(User user) {
		return addUser(user.getName());
	}

	public boolean addUser(String name) {
		int result = jdbcTemplate.update("INSERT INTO public.\"User\" (name) VALUES (?);", name);
		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}

	public List<User> getAllUsers() {
		List<User> users = null;
		users = jdbcTemplate.query("SELECT * FROM public.\"User\";", new UserMapper() );
		return users;
	}

}
