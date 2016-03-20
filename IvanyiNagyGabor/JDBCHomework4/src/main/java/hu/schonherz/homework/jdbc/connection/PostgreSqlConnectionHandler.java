package hu.schonherz.homework.jdbc.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

/**
 * @author Iványi-Nagy Gábor
 *
 */
public class PostgreSqlConnectionHandler extends SqlConnectionHandler {
	
	private static SqlConnectionHandler connectionHandler = new PostgreSqlConnectionHandler();
	
	
	private PostgreSqlConnectionHandler() {}
	
	public static SqlConnectionHandler getInstance() {
		return connectionHandler;
	}

	@Override
	protected DataSource getSqlDataSource() {
		Properties properties = new Properties();
		PGSimpleDataSource dataSource = new PGSimpleDataSource();

		try (FileInputStream fileInputStream = new FileInputStream(new File(PROPERTYSOURCE))) {
			properties.load(fileInputStream);
			dataSource.setUrl(properties.getProperty("POSTGRESQL_DB_URL"));
			dataSource.setUser(properties.getProperty("POSTGRESQL_DB_USERNAME"));
			dataSource.setPassword(properties.getProperty("POSTGRESQL_DB_PASSWORD"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataSource;
	}

}
