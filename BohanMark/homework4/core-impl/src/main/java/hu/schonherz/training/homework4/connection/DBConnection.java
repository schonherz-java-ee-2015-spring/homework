package hu.schonherz.training.homework4.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

/**
 * Class for handle database connection used by hu.schonherz.training.homework4 classes
 * 
 * @author Mark Bohan
 *
 */
public class DBConnection {

	private static PGSimpleDataSource psqlDS = null;
	
	/**
	 * returns the database connection
	 * @return the database connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		return getDataSource().getConnection();
	}

	/**
	 * returns the DataSource of database
	 * @return the DataSource of database
	 */
	public static DataSource getDataSource() {
		if(psqlDS != null)
			return psqlDS;
			
		Properties props = new Properties();
		FileInputStream fis = null;
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
