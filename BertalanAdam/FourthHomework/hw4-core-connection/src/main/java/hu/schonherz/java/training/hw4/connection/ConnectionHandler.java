package hu.schonherz.java.training.hw4.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.ds.PGSimpleDataSource;

/**
 * Class to handle the connection to the PostgreSQL database.
 * */
public final class ConnectionHandler {

	/**
	 * Singleton Creational pattern, this handler shouldn't be instantiated
	 */
	private ConnectionHandler() {
	}

	/**
	 * This method tries to get a connection from a {@link PGSimpleDataSource} object.
	 * The properties for the connection can be found in the db.properties file under the resources folder.
	 * @throws SQLException 
	 * */
	public static Connection getConnection() throws SQLException {
		// store the properties from the file
		Properties properties = new Properties();
		// PostgreSQL DataSource
		PGSimpleDataSource pgdatasource = new PGSimpleDataSource();
		FileInputStream fis;
		
		try {
			// Create a new FileInputStream from a File
			fis = new FileInputStream( 
				new File( 
					// due to resources plugin, the content of a resource folder (already set in pom.xml)
					// will be copied to the target/classes folder
					// in this way we can get the copied file's URI
					ConnectionHandler.class.getResource("/db.properties").toURI()
				)
			);
			// Read the key=element pairs from fis and loads it into the Properties object
			properties.load(fis); // IOException
			
			// set the required information in the PGSimpleDataSource object
			pgdatasource.setUrl(properties.getProperty("DB_URL"));
			pgdatasource.setUser(properties.getProperty("DB_USERNAME"));
			pgdatasource.setPassword(properties.getProperty("DB_PASSWORD"));
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("There is no file called: db.properties here!");
			fnfe.printStackTrace();
			System.exit(-1);
		} catch (IOException ioe) {
			System.out.println("Could not load properties!");
			ioe.printStackTrace();
			System.exit(-1);
		} catch (URISyntaxException e) {
			System.out.println("URI not well formatted!");
			e.printStackTrace();
			System.exit(-1);
		}
		// then get the connection from the PGSimpleDataSource and return with it
		return pgdatasource.getConnection();
	}
}
