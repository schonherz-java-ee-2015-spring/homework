package main;

import java.sql.Connection;
import java.sql.SQLException;

import hu.schonherz.homework.jdbc.connection.SqlConnectionHandlerFactory;
import hu.schonherz.homework.jdbc.dao.UserDaoImpl;
import hu.schonherz.homework.jdbc.metadata.MetaData;
import hu.schonherz.homework.jdbc.model.User;

public class Main {

	public static void main(String[] args) {
		try {
			Connection connection = SqlConnectionHandlerFactory.getSqlConnectionHandler("POSTGRESQL")
					.getSqlConnection();
			
//		MetaData metaData = new MetaData(connection.getMetaData());
//		metaData.printGenaralMetaData();
//		metaData.printTables();
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.getAllUsers().stream().forEach(System.out::println);
//		userDao.addUser(new User(0, "Cica"));
		System.out.println("\n");
//		System.out.println(userDao.getUserById(2));
		System.out.println("\n");
		userDao.deleteUser(new User(5, "Cica"));
		userDao.getAllUsers().stream().forEach(System.out::println);
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
