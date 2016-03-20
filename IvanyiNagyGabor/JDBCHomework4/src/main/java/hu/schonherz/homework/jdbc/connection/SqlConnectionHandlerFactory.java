package hu.schonherz.homework.jdbc.connection;

/**
 * @author Iványi-Nagy Gábor
 *
 */
public class SqlConnectionHandlerFactory {

	private SqlConnectionHandlerFactory() {}
	
	
	public static SqlConnectionHandler getSqlConnectionHandler(String type) {
		
		if (type.equalsIgnoreCase("POSTGRESQL")) {
			return PostgreSqlConnectionHandler.getInstance();
		}
		
		return null;
	}

}
