package hu.schonherz.training.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

public class ConnectionHandler {

	public static Connection getConnection() throws SQLException {
		return getPostgreSqlDataSource().getConnection();
	}

	private static DataSource getPostgreSqlDataSource() {
		PGSimpleDataSource psqlDS = null;
			psqlDS = new PGSimpleDataSource();
			psqlDS.setUrl("jdbc:postgresql://localhost:5432/JDBC_Homework");
			psqlDS.setUser("postgres");
			psqlDS.setPassword("X2S77kOVNme@");

		return psqlDS;
	}

}