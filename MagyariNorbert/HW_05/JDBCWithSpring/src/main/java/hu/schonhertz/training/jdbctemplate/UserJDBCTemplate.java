package hu.schonhertz.training.jdbctemplate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import hu.schonhertz.training.dao.UserDao;
import hu.schonhertz.training.mapper.UserMaper;
import hu.schonhertz.training.pojo.User;

public class UserJDBCTemplate implements UserDao {

	 private JdbcTemplate jdbcTemplate;
	 
	  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		    this.jdbcTemplate = jdbcTemplate;
		  }
	
	@Override
	public List<User> getAllUser() {
	    String sql = "SELECT name, id FROM public.\"User\";";
	    List<User> user = jdbcTemplate.query(sql, new UserMaper());
		return user;
	}

	@Override
	public User getUserById(Long id) {
	    String sql = "SELECT name, id FROM public.\"User\" WHERE id = ?;";
	    User user = jdbcTemplate.queryForObject(sql, new UserMaper(), id);
		return user;
	}

	@Override
	public void createUser(String name, Long id) {
	    String sql = "INSERT INTO public.\"User\"(name) VALUES (?);";
	    jdbcTemplate.update(sql, name);

	}

	@Override
	public void deleteUser(String name) {
		    String sql = "DELETE FROM public.\"User\" WHERE name=?;";
		    jdbcTemplate.update(sql, name);
	}
	
	

}
