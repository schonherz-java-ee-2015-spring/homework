package hu.schonherz.training.hw.jdbc;

import java.util.List;

import hu.schonherz.training.hw.jdbc.dao.UserDAO;
import hu.schonherz.training.hw.jdbc.dao.impl.UserDAOImpl;
import hu.schonherz.training.hw.jdbc.entity.User;

public class UserDAOExample {
	public static void main(String[] args) {
		UserDAO udao = new UserDAOImpl();

		User user = new User(0, "Kati");
		udao.addUser(user);
		System.out.println(user.getId() + " - " + user.getName() + " added.");

		userLister(udao);

		user.setName("Kálmán");
		udao.updateUser(user);
		System.out.println(user.getId() + " updated.");

		userLister(udao);

		udao.deleteUser(user);
		System.out.println(user.getId() + " - " + user.getName() + " deleted.");

		userLister(udao);
	}

	private static void userLister(UserDAO udao) {
		List<User> users = udao.getAllUsers();
		System.out.println("Users");
		for (User u : users) {
			System.out.println(u.getId() + " - " + u.getName());
		}
		System.out.println("----");
	}
}
