package hu.schonherz.homework.jdbc.dao;

import java.util.List;

import hu.schonherz.homework.jdbc.model.User;

/**
 * @author Iványi-Nagy Gábor
 *
 */
public interface UserDao {
	
	public List<User> getAllUsers();
	
	public User getUserById(int id); 
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
}
