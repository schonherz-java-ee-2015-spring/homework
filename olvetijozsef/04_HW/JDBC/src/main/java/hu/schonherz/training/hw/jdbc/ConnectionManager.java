package hu.schonherz.training.hw.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

public class ConnectionManager {

	public static Connection getConnection() throws SQLException {
		return getSqlDataSource().getConnection();
	}

	private static DataSource getSqlDataSource() {
		Properties properties = new Properties();
		FileInputStream fs = null;
		PGSimpleDataSource sqlDS = null;
		try {
			fs = new FileInputStream("database.properties");
			properties.load(fs);
			sqlDS = new PGSimpleDataSource();
			sqlDS.setUrl(properties.getProperty("DB_URL"));
			sqlDS.setUser(properties.getProperty("DB_USERNAME"));
			sqlDS.setPassword(properties.getProperty("DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlDS;
	}

}
