package hu.schonherz.java.training.login.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.java.training.login.entity.User;
import hu.schonherz.java.training.login.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-core-test.xml")
@Transactional
@Rollback(false)
public class DatabaseFiller {

	@Autowired
	UserRepository userDao;

	@Test
	public void testDatabaseFiller() {

		List<User> users = new ArrayList<>();
		users.add(new User("galagonya", "12345", "Budapest, VII.Kerulet", "gal@gmail.com"));
		users.add(new User("kovacslajos", "kov9567", "Debrecen, Laktanya utca 42.", "kovl@gmail.com"));
		users.add(new User("kisjanos", "kisjani12", "Miskolc", "kisjanos@gmail.com"));
		try {
			userDao.save(users);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
