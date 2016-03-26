package hu.schonherz.training.dao;

import java.util.List;

import hu.schonherz.training.classes.User;

public interface UserDao {

	public List<User> getAllUsers();
	
	public User getUserById(int id);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

}
