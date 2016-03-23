package hu.schonherz.homework.order.service.impl;

import java.sql.SQLException;
import java.util.List;

import hu.schonherz.homework.order.connection.impl.PostgreSqlConnectionHandler;
import hu.schonherz.homework.order.dao.UserDao;
import hu.schonherz.homework.order.dao.impl.UserDaoImpl;
import hu.schonherz.homework.order.dto.User;
import hu.schonherz.homework.order.service.UserService;
import hu.schonherz.homework.order.service.mapper.UserMapper;
import hu.schonherz.homework.order.vo.UserVo;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() throws SQLException {
		this.userDao = new UserDaoImpl(PostgreSqlConnectionHandler.getInstance().getConnection());
	}

	@Override
	public List<UserVo> getAllUser() {
		List<User> users = userDao.getAllUsers();
		return UserMapper.toVo(users);
	}

}
