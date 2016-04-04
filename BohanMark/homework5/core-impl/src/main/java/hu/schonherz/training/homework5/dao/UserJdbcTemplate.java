package hu.schonherz.training.homework5.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import hu.schonherz.training.homework5.mapper.UserMapper;
import hu.schonherz.training.homework5.pojo.User;

/**
 * dao for user
 * @author Mark Bohan
 *
 */
public class UserJdbcTemplate implements UserDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * sets the dataSource
	 * 
	 * @param dataSource
	 *            the new dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}
	
	public UserJdbcTemplate(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public User findUserById(Integer id) {
		String sql = "SELECT id, name FROM public.\"User\" WHERE id = ?";
		User user = jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new UserMapper());
		return user;
	}

	@Override
	public User findUserByName(String name) {
		String sql = "SELECT id, name FROM public.\"User\" WHERE name = ?";
		User user = jdbcTemplateObject.queryForObject(sql, new Object[] { name }, new UserMapper());
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "select * from public.\"User\"";
		List<User> users = jdbcTemplateObject.query(sql, new UserMapper());
		return users;
	}

	@Override
	public void createUser(User user) {
		String sql = "INSERT INTO public.\"User\"(name) VALUES ( ? );";

		jdbcTemplateObject.update(sql, user.getName());

	}

}
