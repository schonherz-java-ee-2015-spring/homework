package hu.schonhertz.training.login.service;

import java.util.List;

import hu.schonhertz.training.login.vo.UserVo;

public interface UserService {

	public UserVo findUserByName(String name) throws Exception;

	public void registrationUser(UserVo userVO) throws Exception;

	public List<String> getAllName();
	
	public UserVo findUserByNameAndPassword(String name, String password) throws Exception;

	public List<UserVo> findAll();

}
