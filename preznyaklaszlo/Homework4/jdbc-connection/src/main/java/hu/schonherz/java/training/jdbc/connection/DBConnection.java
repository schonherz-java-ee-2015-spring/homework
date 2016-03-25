package hu.schonherz.java.training.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	private static String DB_USER = "postgres";
	private static String DB_PASSWORD = "lacialegnagyobb";

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.err.println("The connection is successfully obtained");
		return connection;
	}

}
