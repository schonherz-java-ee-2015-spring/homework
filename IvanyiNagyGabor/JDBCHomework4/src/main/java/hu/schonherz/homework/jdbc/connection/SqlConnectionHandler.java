package hu.schonherz.homework.jdbc.connection;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author Iványi-Nagy Gábor
 *
 */
public abstract class SqlConnectionHandler {

	private final String SUBDIRECTORY = "src" + File.separator + "main" + File.separator + "resources"
			+ File.separator;
	private final String FILE = "database.properties";
	
	
	protected final String PROPERTYSOURCE = SUBDIRECTORY + FILE;

	
	public final Connection getSqlConnection() throws SQLException {
		return getSqlDataSource().getConnection();
	}

	protected abstract DataSource getSqlDataSource();

}
