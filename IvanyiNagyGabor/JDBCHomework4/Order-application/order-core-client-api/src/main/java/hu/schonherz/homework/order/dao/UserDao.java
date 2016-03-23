package hu.schonherz.homework.order.dao;

import java.util.List;

import hu.schonherz.homework.order.dto.User;


public interface UserDao {
	
	public List<User> getAllUsers();

	public User getUserById(Integer id);
	
	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);
}
