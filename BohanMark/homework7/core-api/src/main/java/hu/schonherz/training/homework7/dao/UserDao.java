package hu.schonherz.training.homework7.dao;

import hu.schonherz.training.homework7.pojo.User;

public interface UserDao {
	
	public void register(User user);
	
	public boolean login(User user);

	public User findUserById(int id);
	
	public User findUserByName(String username);
	
	
	
}
