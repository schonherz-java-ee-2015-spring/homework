package hu.schonhertz.training.dao;

import java.util.List;

import hu.schonhertz.training.pojo.User;

public interface UserDao {

	public List<User> getAllUser();

	public User getUserById(Long id);

	public void createUser(String name, Long id);
	
	public void deleteUser(String name);
}
