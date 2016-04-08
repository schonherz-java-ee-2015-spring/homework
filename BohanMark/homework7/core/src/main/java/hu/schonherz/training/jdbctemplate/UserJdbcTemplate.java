package hu.schonherz.training.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import hu.schonherz.training.homework7.dao.UserDao;
import hu.schonherz.training.homework7.pojo.User;
import hu.schonherz.training.mapper.UserMapper;

public class UserJdbcTemplate implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void register(User user) {
	    String sql = "INSERT INTO public.\"Users\"(username, password , email, usertype) VALUES (?, ?, ?, ?);";
	    jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getUserType());
	}

	@Override
	public boolean login(User user) {

	    String sql = "SELECT id FROM public.\"Users\" WHERE username = ? AND password = ? ;";
		return jdbcTemplate.queryForList(sql, user.getUsername(), user.getPassword()).size() == 1;
	}

	@Override
	public User findUserById(int id) {
	    String sql = "SELECT * FROM public.\"Users\" WHERE id = ? ;";
		User user = jdbcTemplate.queryForObject(sql, new UserMapper(), id);
		return user;
	}

	@Override
	public User findUserByName(String username) {
	    String sql = "SELECT * FROM public.\"Users\" WHERE username = ? ;";
		User user = jdbcTemplate.queryForObject(sql, new UserMapper(), username);
		return user;
	}
	
}
