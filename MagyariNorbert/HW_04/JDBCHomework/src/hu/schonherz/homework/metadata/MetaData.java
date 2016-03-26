package hu.schonherz.homework.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hu.schonherz.homework.jdbc.ConnectionHandler;

public class MetaData {

	static Connection connection = null;
	static DatabaseMetaData metadata = null;

	// Static block for initialization
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

	/**
	 * 
	 * @return Arraylist with the table's name
	 * @throws SQLException
	 */
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

	/**
	 * Prints in the console the columns metadata, based in the Arraylist of
	 * tables passed as parameter.
	 * 
	 * @param tables
	 * @throws SQLException
	 */
	public static void getColumnsMetadata(ArrayList<String> tables) throws SQLException {
		ResultSet rs = null;
		// Print the columns properties of the actual table
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

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Print all the tables of the database scheme, with their names and
			// structure
			getColumnsMetadata(getTablesMetadata());
		} catch (SQLException e) {
			System.err.println("There was an error retrieving the metadata properties: " + e.getMessage());
		}
	}
}
