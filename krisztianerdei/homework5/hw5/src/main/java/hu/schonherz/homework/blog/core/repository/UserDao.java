package hu.schonherz.homework.blog.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import hu.schonherz.homework.blog.core.entitiy.User;

@Repository
public interface UserDao {
	// Dao interface
	public List<User> getAllUser();

	public User getUserById(int id);

	public void addUser(String name);

	public void deleteUserById(int id);

	public void updateUserName(int id, String name);

	public void getAllUserByCall();

}
