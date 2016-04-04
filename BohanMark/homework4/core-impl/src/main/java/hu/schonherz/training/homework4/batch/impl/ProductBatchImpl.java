package hu.schonherz.training.homework4.batch.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.schonherz.training.homework4.batch.ProductBatch;
import hu.schonherz.training.homework4.connection.DBConnection;
import hu.schonherz.training.homework4.dto.Product;

/**
 * The postgresql implementation of ProductBatch
 * 
 * @author Mark Bohan
 *
 */
public class ProductBatchImpl implements ProductBatch {

	private Connection connection;

	private final int batchSize = 3;

	@SuppressWarnings("javadoc")
	public ProductBatchImpl() {
		super();
		try {
			this.connection = DBConnection.getConnection();
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertProducts(List<Product> products) {
		int count = 0;
		String sql = "INSERT INTO public.\"Product\"(name, price) VALUES ( ? , ? );";

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			for (Product product : products) {
				pstmt.setString(1, product.getName());
				pstmt.setInt(2, product.getPrice());
				pstmt.addBatch();

				if (++count % batchSize == 0) {
					pstmt.executeBatch();
				}

			}
			pstmt.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
				return count - (count % batchSize);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return count;

	}

	@Override
	public int deleteProducts(List<Integer> productIds) {
		int count = 0;
		String sql = "DELETE FROM public.\"Product\" WHERE id = ? ;";

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			for (Integer productId : productIds) {
				pstmt.setInt(1, productId);
				pstmt.addBatch();

				if (++count % batchSize == 0) {
					pstmt.executeBatch();
				}

			}
			pstmt.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
				return count - (count % batchSize);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return count;
	}

}
