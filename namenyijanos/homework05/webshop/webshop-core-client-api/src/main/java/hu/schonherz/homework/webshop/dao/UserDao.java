package hu.schonherz.homework.webshop.dao;

import java.util.List;

import hu.schonherz.homework.webshop.dto.User;

public interface UserDao {

	boolean addUser(User user);
	
	boolean addUser(String name);
	
	List<User> getAllUsers();
}
