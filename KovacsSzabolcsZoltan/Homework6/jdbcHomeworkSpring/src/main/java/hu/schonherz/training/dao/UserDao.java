package hu.schonherz.training.dao;

import java.util.List;

import hu.schonherz.training.pojo.User;

public interface UserDao {

	public List<User> getAllUser();

	public User getUserById(int id);

	public void createUser(String name);
	
	public void removeUser(String name);
}
