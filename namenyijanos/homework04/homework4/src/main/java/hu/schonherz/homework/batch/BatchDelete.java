package hu.schonherz.homework.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.connection.ConnectionHandler;
import hu.schonherz.homework.records.Product;

public class BatchDelete {

	public static void deleteData() {

		//String to store the statement to execute
		String sql = "DELETE FROM \"Product\" WHERE name = ?;";
		//List to store the products to delete
		List<Product> products = new ArrayList<>();
		//Add products to delete to the List
		products.add(new Product(0, 10, "XL Ham Pizza"));
		products.add(new Product(0, 8, "Beer"));
		products.add(new Product(0, 5, "Mineral Water"));

		final int batchSize = 3;
		int count = 0;

		//Create connection within try-with block and prepare the statement
		try (Connection connection = ConnectionHandler.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			
			//disable auto commit, need to commit manually
			connection.setAutoCommit(false);
			//for loop to add the products to the batch
			for (Product product : products) {
				statement.setString(1, product.getName());
				statement.addBatch();
				System.out.println("Product: '" + product.getName() + "' added to batch.");
				//determine that last 'member' of the batch or not
				if (++count % batchSize == 0) {
					System.out.println("Count size: " + count);
					System.out.println("Count size reaches the batch size...");
					int[] executedBatchSize = statement.executeBatch();
					System.out.println("Batch executed... Batch Size: " + executedBatchSize.length);
				}
			}
			int[] remainingRows = statement.executeBatch();
			System.out.println("Batch executed for remaining rows... Batch Size: " + remainingRows.length);
			// commit manually
			connection.commit();
			System.out.println("Batch commited...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
