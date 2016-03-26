package hu.schonherz.java.training.jdbc.dao;

import java.util.List;

import hu.schonherz.java.training.jdbc.records.User;

public interface UserDao {

	public List<User> getAllUsers();

	public User getUserByName(String name);

	public User getUserById(Integer id);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

}
