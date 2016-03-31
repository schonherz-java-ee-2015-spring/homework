package hu.schonhertz.training.blog.service;

import java.util.List;

import hu.schonhertz.training.blog.vo.UserVo;

public interface UserService {

	public UserVo findUserByName(String name) throws Exception;

	public void registrationUser(UserVo userVO) throws Exception;
	
	public void changeRolesToUser(UserVo userVo) throws Exception;
	
	public UserVo setUpRoles(UserVo vo) throws Exception;
	
	public List<UserVo> getAllUser() throws Exception;
	
	public List<UserVo> getAllUserBySorted() throws Exception;
	
}
