package hu.schonherz.training.hw.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hu.schonherz.training.hw.jdbc.ConnectionManager;

/**
 * 
 * @author Ölveti József
 *
 */
public class Metadata {

	static Connection connection = null;
	static DatabaseMetaData metadata = null;

	static {
		try {
			connection = ConnectionManager.getPostgreConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		try {
			metadata = connection.getMetaData();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

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

	public static void getColumnsMetadata(ArrayList<String> tables) throws SQLException {
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
