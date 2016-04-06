package hu.schonhertz.training.blog.service;

import java.util.List;

import hu.schonhertz.training.blog.vo.RoleVo;
import hu.schonhertz.training.blog.vo.UserVo;

public interface UserService {

	public UserVo findUserByName(String name) throws Exception;

	public void registrationUser(UserVo userVO) throws Exception;

// ADMIN PART
	public UserVo setUpRoles(UserVo vo, List<RoleVo> roles) throws Exception;
	
	//nemkell
	public List<UserVo> getAllUsers() throws Exception;
}
