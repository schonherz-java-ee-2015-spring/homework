package hu.schonherz.training.hw.jdbc.metadata;

import java.sql.SQLException;

import hu.schonherz.training.hw.jdbc.metadata.Metadata;

/**
 * 
 * @author Ölveti József
 *
 */
public class MetaDataExample {
	public static void main(String[] args) {
		try {
			Metadata.getColumnsMetadata(Metadata.getTablesMetadata());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
