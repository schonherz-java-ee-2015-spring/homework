package hu.schonherz.homework.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.jdbc.ConnectionHandler;
import hu.schonherz.homework.records.Product;

public class BatchQueries {
	public static void main(String[] args) {
		InsertProductBatch();
		
		List<Product> lista = new ArrayList<>();
		System.out.println("Between INSERT and DELETE:");
		for (Product product : lista) {
			System.out.println(product);
		}
		
		DeleteProductBatch();
	}

	private static void InsertProductBatch() {

		String sql = "INSERT INTO public.\"Product\" (name, price) VALUES (?, ?)";
		List<Product> products = new ArrayList<>();
		products.add(new Product(0, 130, "Fakanál"));
		products.add(new Product(0, 1523, "Autó"));
		products.add(new Product(0, 543, "Telefon"));
		products.add(new Product(0, 542, "Mobil"));
		products.add(new Product(0, 123, "Laptop"));
		products.add(new Product(0, 321, "Monitor"));
		

		final int batchSize = 2;
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
		}
	}
	
	
	private static void DeleteProductBatch() {

		String sql = "DELETE FROM public.\"Product\" WHERE name=?";
		List<Product> products = new ArrayList<>();
		products.add(new Product(0, 130, "Fakanál"));
		products.add(new Product(0, 1523, "Autó"));
		products.add(new Product(0, 543, "Telefon"));
		

		final int batchSize = 2;
		int count = 0;

		try (Connection connection = ConnectionHandler.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (Product product : products) {
				statement.setString(1, product.getName());
				statement.addBatch();
				System.out.println("Product: " + product.getName() + " added to batch.");
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
		}
	}

}
