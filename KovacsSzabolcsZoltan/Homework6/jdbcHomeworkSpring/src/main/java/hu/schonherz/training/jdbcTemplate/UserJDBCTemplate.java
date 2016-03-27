package hu.schonherz.training.jdbcTemplate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import hu.schonherz.training.dao.UserDao;
import hu.schonherz.training.mapper.UserMapper;
import hu.schonherz.training.pojo.User;

public class UserJDBCTemplate implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<User> getAllUser() {
		String sql = "SELECT id, name FROM public.\"User\";";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}

	public User getUserById(int id) {
		String sql = "SELECT id, name FROM public.\"User\" WHERE id = ?;";
		User user = jdbcTemplate.queryForObject(sql, new UserMapper(), id);
	    return user;
	}

	public void createUser(String name) {
		String sql = "INSERT INTO public.\"User\"(name) VALUES (?);";
	    jdbcTemplate.update(sql, name);
	}

	public void removeUser(String name) {
		String sql = "DELETE FROM public.\"User\" WHERE name LIKE ?;";
		jdbcTemplate.update(sql, name);
	}

}
