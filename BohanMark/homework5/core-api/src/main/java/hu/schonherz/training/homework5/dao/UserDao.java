package hu.schonherz.training.homework5.dao;

import java.util.List;

import hu.schonherz.training.homework5.pojo.User;

/**
 * Data Access Object for users
 * 
 * @author Mark Bohan
 *
 */
public interface UserDao {
	/**
	 * finds the user by it's id
	 * 
	 * @param id
	 *            the id of user
	 * @return the found user
	 */
	public User findUserById(Integer id);

	/**
	 * finds the user by it's name
	 * 
	 * @param name
	 *            the name of user
	 * @return the found user
	 */
	public User findUserByName(String name);

	/**
	 * returns all users
	 * 
	 * @return the list of all users
	 */
	public List<User> getAllUsers();

	/**
	 * creates a user
	 * 
	 * @param user
	 *            the user to create
	 */
	public void createUser(User user);

}
