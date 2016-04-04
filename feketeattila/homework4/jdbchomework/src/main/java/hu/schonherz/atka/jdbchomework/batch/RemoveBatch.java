package hu.schonherz.atka.jdbchomework.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.atka.jdbchomework.connection.ConnectionHandler;

public class RemoveBatch {

	public static void main(String[] args) {
		String sql = "DELETE FROM public.\"Product\" WHERE id = ? ;";
		List<Integer> productIds = new ArrayList<>();
		productIds.add(8);
		productIds.add(9);
		productIds.add(10);
		productIds.add(11);
		productIds.add(12);
		productIds.add(13);
		productIds.add(14);

		final int batchSize = 3;
		int count = 0;

		try (Connection connection = ConnectionHandler.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (Integer productId : productIds) {
				statement.setInt(1, productId);
				statement.addBatch();
				System.out.println("Product: " + productId + " added to batch.");
				if (++count % batchSize == 0) {
					int[] executedBatchSize = statement.executeBatch();
					System.out.println("Batch executed... Batch Size: " + executedBatchSize.length);
				}
			}
			int[] remainingRows = statement.executeBatch();
			System.out.println("Batch executed for remaining rows... Batch Size: " + remainingRows.length);
			connection.commit();
			System.out.println("Batch commited...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
