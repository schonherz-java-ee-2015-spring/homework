package hu.schonherz.homework.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hu.schonherz.homework.connection.ConnectionHandler;

public class GetMetadata {
	
	static Connection connection = null;
	static DatabaseMetaData metadata = null;
	
	//static block for create connection and get metadata of the db
	static {
		try {
			connection = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			System.err.println("There was an error getting the connection: " + e.getMessage());
		}

		try {
			metadata = connection.getMetaData();
		} catch (SQLException e) {
			System.err.println("There was an error getting the metadata: " + e.getMessage());
		}
	}
	
	//this method prints the general metadata of db to the console
	public static void printGeneralMetadata() throws SQLException {
		System.out.println("Database Product Name: " + metadata.getDatabaseProductName());
		System.out.println("Database Product Version: " + metadata.getDatabaseProductVersion());
		System.out.println("Logged User: " + metadata.getUserName());
		System.out.println("JDBC Driver: " + metadata.getDriverName());
		System.out.println("Driver Version: " + metadata.getDriverVersion());
		System.out.println("Support Transactions: " + metadata.supportsTransactions());
		System.out.println("Support TRANSACTION_NONE(0): " + metadata.supportsTransactionIsolationLevel(Connection.TRANSACTION_NONE));		
		System.out.println("Support READ_UNCOMMITED(1): " + metadata.supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_UNCOMMITTED));
		System.out.println("Support READ_COMMITED(2): " + metadata.supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_COMMITTED));
		System.out.println("Support REPEATABLE_READ(4): " + metadata.supportsTransactionIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ));
		System.out.println("Support SERIALIZABLE(8): " + metadata.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE));
		System.out.println("Default Isolation Level: " + metadata.getDefaultTransactionIsolation());
		System.out.println("\n");
	}
	
	public static ArrayList<String> getTablesMetadata() throws SQLException {
		String table[] = { "TABLE" };
		ResultSet rs = null;
		//List to store tables
		ArrayList<String> tables = null;
		rs = metadata.getTables(null, null, null, table);
		tables = new ArrayList<String>();
		while (rs.next()) {
			tables.add(rs.getString("TABLE_NAME"));
		}
		return tables;
	}
	
	public static void getColumnsMetadata(ArrayList<String> tables) throws SQLException {
		ResultSet rs = null;
		//get the metadadata of all columns of all columns
		for (String actualTable : tables) {
			rs = metadata.getColumns(null, null, actualTable, null);
			System.out.println(actualTable.toUpperCase());
			while (rs.next()) {
				System.out.println(rs.getString("COLUMN_NAME") + " " + rs.getString("TYPE_NAME") + " "
						+ rs.getString("COLUMN_SIZE"));
			}
			System.out.println("\n");
		}

	}
	
}
