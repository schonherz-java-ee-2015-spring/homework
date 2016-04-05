package hu.schonherz.homework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.homework.core.dao.Dao;
import hu.schonherz.homework.core.dto.UserDto;
import hu.schonherz.homework.service.interf.ServiceInterf;
import hu.schonherz.homework.service.mapper.UserMapper;
import hu.schonherz.homework.service.vo.UserVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements ServiceInterf<UserVo> {
	
	@Autowired
	private Dao<UserDto> userDao;

	@Override
	public List<UserVo> getAllVos() {
		return UserMapper.toVo(userDao.getAllElements());
	}

	@Override
	public void addVo(UserVo userVo) {
		userDao.addElement(UserMapper.toDto(userVo));
	}

}
