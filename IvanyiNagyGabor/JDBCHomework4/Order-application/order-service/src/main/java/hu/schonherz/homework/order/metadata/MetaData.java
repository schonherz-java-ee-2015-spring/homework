package hu.schonherz.homework.order.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.schonherz.homework.order.connection.ConnectionHandler;

public class MetaData {

	private static final String[] TABLE = { "TABLE" };
	private static final String TABLE_NAME = "TABLE_NAME";
	private static final String COLUMN_NAME = "COLUMN_NAME";

	private static Connection connection = null;
	private static DatabaseMetaData metaData = null;

	/**
	 * Try to connect the dataBase and ask the MetaData
	 */
	static {
		try {
			connection = ConnectionHandler.getConnection();
			metaData = connection.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Print some general information and the table names and theirs column names
	 */
	public static void printMetaData() throws SQLException {
		System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
		System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
		System.out.println("Logged User: " + metaData.getUserName());
		System.out.println("JDBC Driver: " + metaData.getDriverName());
		System.out.println("Driver Version: " + metaData.getDriverVersion());
		getTables(getTableTitles())
				.forEach((k, v) -> System.out.println("Table name: " + k.toUpperCase() + "\n" + "Columns: " + v));
	}

	/**
	 * Return the table names
	 */
	private static List<String> getTableTitles() throws SQLException {

		ResultSet resultSet = metaData.getTables(null, null, null, TABLE);
		List<String> tableTitles = new ArrayList<String>();
		while (resultSet.next()) {
			tableTitles.add(resultSet.getString(TABLE_NAME));

		}
		return tableTitles;
	}

	/**
	 * Return the tables names and theis column names
	 */
	private static Map<String, List<String>> getTables(List<String> tableTitles) throws SQLException {
		Map<String, List<String>> tables = new HashMap<String, List<String>>();
		for (String actualTable : tableTitles) {
			List<String> columnNames = new ArrayList<String>();
			ResultSet resultSet = metaData.getColumns(null, null, actualTable, null);
			while (resultSet.next()) {
				columnNames.add(resultSet.getString(COLUMN_NAME));
			}
			tables.put(actualTable, columnNames);
		}
		return tables;
	}

}
