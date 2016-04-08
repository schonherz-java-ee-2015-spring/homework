package hu.schonhertz.homework.service;

import hu.schonhertz.homework.vo.UserVo;

public interface UserService {

	public UserVo findUserByName(String name) throws Exception;
	
	public UserVo findUserByNameAndPassword(String name, String password) throws Exception;

	public void registrationUser(UserVo userVO) throws Exception;

	public UserVo setUpRoles(UserVo vo) throws Exception;
}
