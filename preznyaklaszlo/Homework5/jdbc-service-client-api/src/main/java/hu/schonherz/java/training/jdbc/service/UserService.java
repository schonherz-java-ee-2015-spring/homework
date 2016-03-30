package hu.schonherz.java.training.jdbc.service;

import java.util.List;

import hu.schonherz.java.training.jdbc.vo.ProductVo;
import hu.schonherz.java.training.jdbc.vo.UserVo;

public interface UserService {
	public List<UserVo> getAllUsers();

	public UserVo getUserByName(String name);

	public UserVo getUserById(Integer id);

	public void addUser(UserVo user);

	public void updateUser(UserVo user);

	public void deleteUser(UserVo user);

	public List<ProductVo> getOrdersOfAUser(UserVo user);

}
