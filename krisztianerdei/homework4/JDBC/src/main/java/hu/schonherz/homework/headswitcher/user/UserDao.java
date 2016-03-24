package hu.schonherz.homework.headswitcher.user;

import java.util.List;

public interface UserDao {
	// comments at the Userdaoimpl.
	public List<User> getAllUser();

	public User getUserById(int id);

	public void addUser(String name);

	public void deleteUserById(int id);

	public void updateUserName(int id, String name);
	
	public void getAllUserByCall();

}
