package hu.schonherz.training.hw.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

/**
 * Implements the Connection Managing functions.
 * 
 * @author Ölveti József
 *
 */
public class ConnectionManager {

	private static final String DATABASE_PROPERTIES = "database.properties";

	/**
	 * Returns with a new PostgreSQL connection.
	 * 
	 * @return SQL Connection object
	 * @throws SQLException
	 */
	public static Connection getPostgreConnection() throws SQLException {
		return getPostgreSqlDataSource().getConnection();
	}

	/**
	 * Returns with the PostgreSQL datasource.
	 * 
	 * @return the DataSource object
	 */
	private static DataSource getPostgreSqlDataSource() {
		Properties props = new Properties();
		PGSimpleDataSource psqlDS = null;
		try (FileInputStream fis = new FileInputStream(DATABASE_PROPERTIES)) {
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
