package hu.schonherz.homework.order.connection.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

import hu.schonherz.homework.order.connection.ConnectionHandler;

public class PostgreSqlConnectionHandler implements ConnectionHandler {

	private static final String SUBDIRECTORY = "src" + File.separator + "main" + File.separator + "resources";
	private static final String FILENAME = "database.properties";
	private static final String ABSOLUTEFILEPATH = SUBDIRECTORY + File.separator + FILENAME;

	private static final ConnectionHandler connectionHandler = new PostgreSqlConnectionHandler();

	private PostgreSqlConnectionHandler() {
	}

	public static ConnectionHandler getInstance() {
		return connectionHandler;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return getPostgreSqlDataSource().getConnection();
	}

	private DataSource getPostgreSqlDataSource() {
		Properties props = new Properties();
		PGSimpleDataSource dataSource = null;
		try (FileInputStream fileInputStream = new FileInputStream(new File(ABSOLUTEFILEPATH))) {
			props.load(fileInputStream);
			dataSource = new PGSimpleDataSource();
			dataSource.setUrl(props.getProperty("POSTGRESQL_DB_URL"));
			dataSource.setUser(props.getProperty("POSTGRESQL_DB_USERNAME"));
			dataSource.setPassword(props.getProperty("POSTGRESQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

}
