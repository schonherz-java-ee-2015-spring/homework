package hu.schonherz.training.hw.jdbc.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.hw.jdbc.ConnectionManager;
import hu.schonherz.training.hw.jdbc.dao.ProductDAO;
import hu.schonherz.training.hw.jdbc.dao.impl.ProductDAOImpl;
import hu.schonherz.training.hw.jdbc.entity.Product;

/**
 * 
 * @author Ölveti József
 *
 */
public class BatchJDBCApp {

	private static void batchInsertProducts() {
		String sql = "INSERT INTO public.\"Product\" (name, price) VALUES (?, ?)";
		List<Product> products = new ArrayList<>();
		products.add(new Product(0, "Product1", 10));
		products.add(new Product(0, "Product2", 20));
		products.add(new Product(0, "Product3", 30));
		products.add(new Product(0, "Product4", 40));
		products.add(new Product(0, "Product5", 50));
		final int batchSize = 2;
		int count = 0;
		try (Connection connection = ConnectionManager.getPostgreConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (Product product : products) {
				statement.setString(1, product.getName());
				statement.setDouble(2, product.getPrice());
				statement.addBatch();
				System.out.println("Product: " + product.getName() + " felvéve.");
				if (++count % batchSize == 0) {
					System.out.println("Termék szám: " + count);
					System.out.println("Maximális, egyidejű termék elérve.");
					int[] executedBatchSize = statement.executeBatch();
					System.out.println("Feltöltés futtatva. Feltöltött termék: " + executedBatchSize.length);
				}
			}
			int[] remainingRows = statement.executeBatch();
			System.out.println("Feltöltés futtatva. Feltöltött termék: " + remainingRows.length);
			connection.commit();
			System.out.println("Feltöltés mostantól végleges.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void batchDeleteAllProducts() {
		ProductDAO daoImp = new ProductDAOImpl();
		List<Product> products = daoImp.getAllProducts();
		String sql = "DELETE FROM public.\"Product\" WHERE id = ?;";

		final int batchSize = 2;
		int count = 0;
		try (Connection connection = ConnectionManager.getPostgreConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (Product product : products) {
				statement.setInt(1, product.getId());
				statement.addBatch();
				System.out.println(product.getName() + " törlésre felvéve.");
				if (++count % batchSize == 0) {
					System.out.println("Egy időben törölhető elemek száma elérve...");
					int[] executedBatchSize = statement.executeBatch();
					System.out.println("Törlés megtörtént. Törölt elem szám: " + executedBatchSize.length);
					System.out.println("Maradó elemek: " + (products.size() - count));
				}
			}
			int[] remainingRows = statement.executeBatch();
			System.out.println("Törlés megtörtént. Törölt elem: " + remainingRows.length);
			connection.commit();
			System.out.println("Törlés végleges.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] argv) {
		batchInsertProducts();
		System.out.println();
		batchDeleteAllProducts();
	}
}
