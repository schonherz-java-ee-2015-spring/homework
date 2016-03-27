package hu.shonherz.training.homework4.dao.impl.test;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import hu.schonherz.training.homework4.dao.UserDao;
import hu.schonherz.training.homework4.dao.impl.UserDaoImpl;
import hu.schonherz.training.homework4.dto.User;

@SuppressWarnings("javadoc")
public class UserDaoImplTest {

	UserDao userDao = null;

	@Before
	public void setUp() throws Exception {
		userDao = new UserDaoImpl();
	}
	
	@Test
	public void testCreateAndFindUser(){
		User user = new User();
		user.setName("test" + new Random().nextInt());
		userDao.createUser(user);
		
		User usertest = userDao.findUserByName(user.getName());
		Assert.assertEquals(user.getName(), usertest.getName());
		
		User usertest2 = userDao.findUserById(usertest.getId()); 
		
		Assert.assertEquals(usertest.getName(), usertest2.getName());
		
	}

	@Test
	public void testCreateUserAndGetAllUsers() {
		Integer usersize = userDao.getAllUsers().size();
		
		User user = new User();
		user.setName("test" + new Random().nextInt());
		
		userDao.createUser(user);
		
		Assert.assertEquals(usersize+1, userDao.getAllUsers().size());
		
	}

}
