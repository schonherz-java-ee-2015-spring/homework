package hu.schonherz.homework.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

public class ConnectionHandler {

	public static Connection getConnection() throws SQLException {
		return getPostgreSqlDataSource().getConnection();
	}

	private static DataSource getPostgreSqlDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		PGSimpleDataSource psqlDS = null;
		try {
			fis = new FileInputStream("database.properties");
			props.load(fis);
			psqlDS = new PGSimpleDataSource();
			psqlDS.setUrl(props.getProperty("POSTGRESQL_DB_URL"));
			psqlDS.setUser(props.getProperty("POSTGRESQL_DB_USERNAME"));
			psqlDS.setPassword(props.getProperty("POSTGRESQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return psqlDS;
	}

}