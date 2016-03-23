package hu.schonherz.homework.order.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.schonherz.homework.order.connection.impl.PostgreSqlConnectionHandler;

public class MetaData {

	private static final String[] TABLE = { "TABLE" };
	private static final String TABLE_NAME = "TABLE_NAME";
	private static final String COLUMN_NAME = "COLUMN_NAME";

	private static Connection connection = null;
	private static DatabaseMetaData metaData = null;

	static {
		try {
			connection = PostgreSqlConnectionHandler.getInstance().getConnection();
			metaData = connection.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void printMetaData() throws SQLException {
		System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
		System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
		System.out.println("Logged User: " + metaData.getUserName());
		System.out.println("JDBC Driver: " + metaData.getDriverName());
		System.out.println("Driver Version: " + metaData.getDriverVersion());
		getTables(getTableTitles())
				.forEach((k, v) -> System.out.println("Table name: " + k.toUpperCase() + "\n" + "Columns: " + v));
	}

	private static List<String> getTableTitles() throws SQLException {

		ResultSet resultSet = metaData.getTables(null, null, null, TABLE);
		List<String> tableTitles = new ArrayList<String>();
		// receive the Type of the object in a String array.
		while (resultSet.next()) {
			tableTitles.add(resultSet.getString(TABLE_NAME));

		}
		return tableTitles;
	}

	private static Map<String, List<String>> getTables(List<String> tableTitles) throws SQLException {
		Map<String, List<String>> tables = new HashMap<String, List<String>>();
		
		// Print the columns properties of the actual table
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
