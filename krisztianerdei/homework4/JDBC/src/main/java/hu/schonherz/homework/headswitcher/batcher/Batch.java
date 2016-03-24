package hu.schonherz.homework.headswitcher.batcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.schonherz.homework.headswitcher.connection.BurnedInHandler;
import hu.schonherz.homework.headswitcher.product.ProductWuId;

public class Batch {

	public static void BatchInsertProducts(List<ProductWuId> products , int batchSize ){
		
		String sql = "INSERT INTO public.\"Product\"(name, price) VALUES (?, ?);";
		
		int count = 0;
		try (Connection connection = BurnedInHandler.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (ProductWuId product : products) {
				
				statement.setString(1, product.getName());
				statement.setInt(2, product.getPrice());
				statement.addBatch();
				if (++count % batchSize == 0) {
					System.out.println("Count size: " + count);
					System.out.println("Count size reaches the batch size...");
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
			System.out.println("Batch failed...");
		}
	}
	
public static void BatchDeleteProducts(List<Integer> ids , int batchSize ){
		
		String sql = "DELETE FROM public.\"Product\" WHERE id=?;";
		
		int count = 0;
		try (Connection connection = BurnedInHandler.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (Integer integer : ids) {	
				statement.setInt(1, integer);
				statement.addBatch();
				if (++count % batchSize == 0) {
					System.out.println("Count size: " + count);
					System.out.println("Count size reaches the batch size...");
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
			System.out.println("Batch failed...");
		}
	}
	
}
