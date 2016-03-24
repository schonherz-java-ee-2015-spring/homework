package hu.schonherz.training.hw.spring.dao;

import java.util.List;

import hu.schonherz.training.hw.spring.dto.User;

public interface UserDAO {

	void addUser(String userName);

	void updateUser(User user);

	void deleteUser(Integer userId);

	User getUserById(Integer userId);

	List<User> getAllUsers();
}
