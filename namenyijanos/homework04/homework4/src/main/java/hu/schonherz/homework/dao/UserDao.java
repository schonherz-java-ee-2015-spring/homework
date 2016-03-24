package hu.schonherz.homework.dao;

import java.util.List;

import hu.schonherz.homework.records.User;

public interface UserDao {
	
	public List<User> getAllUsers();
	
	public List<User> getUsersCS();

	public User getUser(String name);
	
	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

}
