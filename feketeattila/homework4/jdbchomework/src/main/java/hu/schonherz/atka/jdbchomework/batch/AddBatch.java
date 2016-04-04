package hu.schonherz.atka.jdbchomework.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.atka.jdbchomework.connection.ConnectionHandler;
import hu.schonherz.atka.jdbchomework.pojo.Product;

public class AddBatch {
	public static void main(String[] argv) {

		String sql = "INSERT INTO public.\"Product\" (name, price) VALUES (?, ?)";
		List<Product> products = new ArrayList<>();
		products.add(new Product(0, "ProductBatch1", 100));
		products.add(new Product(0, "ProductBatch2", 200));
		products.add(new Product(0, "ProductBatch3", 300));
		products.add(new Product(0, "ProductBatch4", 400));
		products.add(new Product(0, "ProductBatch5", 500));
		products.add(new Product(0, "ProductBatch6", 600));
		products.add(new Product(0, "ProductBatch7", 700));

		final int batchSize = 3;
		int count = 0;

		try (Connection connection = ConnectionHandler.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (Product product : products) {
				statement.setString(1, product.getName());
				statement.setInt(2, product.getPrice());
				statement.addBatch();
				System.out.println("Product: " + product.getName() + " added to batch.");
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
