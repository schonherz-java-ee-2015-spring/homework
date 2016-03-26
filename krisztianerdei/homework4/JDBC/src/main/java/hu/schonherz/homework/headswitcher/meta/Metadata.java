package hu.schonherz.homework.headswitcher.meta;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.headswitcher.connection.BurnedInHandler;

public class Metadata {

	static Connection connection = null;
	static DatabaseMetaData metadata = null;  // get connection for the database
	static {
		try {
			connection = BurnedInHandler.getConnection();
		} catch (SQLException e) {
			System.err.println("There was an error getting the connection: " + e.getMessage());
		}

		try {
			metadata = connection.getMetaData();
		} catch (SQLException e) {
			System.err.println("There was an error getting the metadata: " + e.getMessage());
		}
	}

	// get metadata trough connection.getMetadata, and returning with the tables
	
	public static ArrayList<String> getTablesMetadata() throws SQLException {
		String table[] = { "TABLE" };
		ResultSet rs = null;
		ArrayList<String> tables = null;
		rs = metadata.getTables(null, null, null, table);
		tables = new ArrayList<String>();
		while (rs.next()) {
			tables.add(rs.getString("TABLE_NAME"));
		}
		return tables;
	}

	// We get the column metadata trough the getColumns method, and printing the result on the console
	
	public static void getColumnsMetadata(List<String> tables) throws SQLException {
		ResultSet rs = null;
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
