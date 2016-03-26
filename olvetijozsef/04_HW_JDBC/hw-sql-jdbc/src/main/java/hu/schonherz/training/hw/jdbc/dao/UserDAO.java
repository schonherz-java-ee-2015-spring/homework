package hu.schonherz.training.hw.jdbc.dao;

import java.util.List;

import hu.schonherz.training.hw.jdbc.entity.User;

public interface UserDAO {

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public User getUserById(int id);

	public List<User> getAllUsers();
}
