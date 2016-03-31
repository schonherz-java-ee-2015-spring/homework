package hu.schonherz.java.training.jdbc.dao;

import java.util.List;

import hu.schonherz.java.training.jdbc.records.User;

public interface UserDao {

	public List<User> getAllUsers();

	public void addUser(User user);

}
