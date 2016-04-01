package hu.schonherz.java.training.jdbc.core.dao;

import java.util.List;

import hu.schonherz.java.training.jdbc.core.records.User;

public interface UserDao {

	public List<User> getAllUsers();

	public void addUser(User user);

}
