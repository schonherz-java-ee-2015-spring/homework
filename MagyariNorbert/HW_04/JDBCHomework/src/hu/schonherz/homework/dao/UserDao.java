package hu.schonherz.homework.dao;

import java.util.List;
import hu.schonherz.homework.records.User;

public interface UserDao {

	public List<User> getAllUser();

	public void addUser(String name);

	public void updateUserNameById(String name, int id);

	public void deleteUserByIdAndName(User user);
}