package hu.schonherz.training.hw.spring.web;

import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.schonherz.training.hw.spring.web.vo.RoleVO;
import hu.schonherz.training.hw.spring.web.vo.UserVO;

public class MockData {

	public static UserVO findUserAndRolesByName(String username) {

		ArrayList<RoleVO> roles = new ArrayList<>();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = null;

		if (username.equals("admin")) {
			password = bCryptPasswordEncoder.encode("admin");
			roles.add(new RoleVO("ROLE_ADMIN"));
		} else {
			return null;
		}

		UserVO userVO = new UserVO();
		userVO.setUserName(username);
		userVO.setPassword(password);
		userVO.setRoles(roles);

		return userVO;
	}

}
