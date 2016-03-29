package hu.schonherz.homework.blog.core.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.blog.core.entitiy.User;
import hu.schonherz.homework.blog.core.mapper.UserMapper;
import hu.schonherz.homework.blog.core.repository.UserDao;

@Repository
public class UserJDBCTemplate implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<User> getAllUser() {
		String sql = "SELECT id, name FROM public.\"User\";";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(String name) {
		String sql = "INSERT INTO public.\"User\"(name) VALUES (?);";
	    jdbcTemplate.update(sql, name);
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserName(int id, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllUserByCall() {
		// TODO Auto-generated method stub
		
	}


}
