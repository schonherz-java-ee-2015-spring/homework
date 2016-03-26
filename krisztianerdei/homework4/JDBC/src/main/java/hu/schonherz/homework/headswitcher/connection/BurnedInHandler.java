package hu.schonherz.homework.headswitcher.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BurnedInHandler {

	public static Connection getConnection() throws SQLException { // connection for the database
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/homework",
		"postgres", "umpalumpa"); 
	}

}