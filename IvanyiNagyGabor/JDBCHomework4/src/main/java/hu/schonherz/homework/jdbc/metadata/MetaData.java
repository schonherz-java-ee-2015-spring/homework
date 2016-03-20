package hu.schonherz.homework.jdbc.metadata;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Iványi-Nagy Gábor
 *
 */
public class MetaData {

	private DatabaseMetaData metadata;
	private static final String TABLE = "TABLE";
	private static final String TABLE_NAME = "TABLE_NAME";
	private static final String COLUMN_NAME = "COLUMN_NAME";

	public MetaData(DatabaseMetaData metaData) {
		super();
		this.metadata = metaData;
	}

	public void printGenaralMetaData() throws SQLException {
		System.out.println("Database Product Name: " + metadata.getDatabaseProductName());
		System.out.println("Database Product Version: " + metadata.getDatabaseProductVersion());
		System.out.println("Logged User: " + metadata.getUserName());
		System.out.println("JDBC Driver: " + metadata.getDriverName());
		System.out.println("Driver Version: " + metadata.getDriverVersion());
		System.out.println("\n\n");
	}

	public void printTables() throws SQLException {
		Map<String, List<String>> tables = getTablesMetaData(getTableNamesMetaData());
		tables.forEach((k, v) -> System.out.println("TableName: " + k + "\n" + "Column(s): " + v + "\n"));
	}

	private List<String> getTableNamesMetaData() throws SQLException {
		ResultSet set = metadata.getTables(null, null, null, new String[] { TABLE });
		List<String> tableNames = new ArrayList<String>();
		while (set.next()) {
			tableNames.add(set.getString(TABLE_NAME));
		}
		return tableNames;
	}

	private Map<String, List<String>> getTablesMetaData(List<String> tableNames) throws SQLException {
		Map<String, List<String>> tables = new HashMap<String, List<String>>();
		ResultSet set = null;
		List<String> tableColumns;
		for (String tableName : tableNames) {
			set = metadata.getColumns(null, null, tableName, null);
			tableColumns = new ArrayList<String>();
			while (set.next()) {
				tableColumns.add(set.getString(COLUMN_NAME));
			}
			tables.put(tableName, tableColumns);
		}

		return tables;
	}

}
