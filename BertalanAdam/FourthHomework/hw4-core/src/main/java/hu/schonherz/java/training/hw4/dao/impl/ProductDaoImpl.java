package hu.schonherz.java.training.hw4.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.hw4.connection.ConnectionHandler;
import hu.schonherz.java.training.hw4.dao.ProductDao;
import hu.schonherz.java.training.hw4.dto.Product;

public class ProductDaoImpl implements ProductDao {
	
	private Connection conn;

	/**
	 * Parameterless constructor to build the connection.
	 * */
	public ProductDaoImpl() {
		try {
			conn = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			System.out.println("Something wrong happened in the ProductDaoImpl constructor!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes a query with two parameters.
	 * Note: Uses PreparedStatement.
	 * @param id The first parameter of the query.
	 * @param name The second parameter of the query.
	 * @param sql The sql expression that will be executed.
	 * @return A boolean indicating the success of the operation.
	 * */
	private boolean executeOwnQuery(int id, String name, String sql){
		boolean executeresult = false;

		try( PreparedStatement pstmnt = conn.prepareStatement(sql); ){
						
			pstmnt.setInt(1, id);
			pstmnt.setString(2, name);
			
			executeresult = pstmnt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return executeresult;
	}
	
	@Override
	public boolean addProduct(Product product) {
		return addProduct(product.getId(), product.getName());
	}

	@Override
	public boolean addProduct(int id, String name) {
		 return executeOwnQuery(id, name, "INSERT INTO public.\"Product\" (id, name) VALUES (?,?);");
	}

	/**
	 * Note: Uses PreparedStatement.
	 * */
	@Override
	public boolean updateProduct(Product product) {
		String sql = "UPDATE public.\"Product\" SET name=? WHERE id=?;";
		boolean executeresult = false;
		
		try( PreparedStatement pstmnt = conn.prepareStatement(sql); ){
			
			pstmnt.setString(1,  product.getName());
			pstmnt.setInt(2, product.getId());
			
			executeresult = pstmnt.execute();
			
		} catch (SQLException e) {
			System.out.println("Something wrong happened while executing getAllOrders()!");
			e.printStackTrace();
		}
		return executeresult;
	}

	@Override
	public boolean deleteProduct(Product product) {
		return deleteProduct(product.getId(), product.getName());
	}
	
	@Override
	public boolean deleteProduct(String name) {
		return deleteProduct( 0, name );
	}
	
	@Override
	public boolean deleteProduct(int id, String name) {
		return executeOwnQuery(id, name, "DELETE FROM public.\"Product\" WHERE id=? OR name=?;");
	}

	/**
	 * Note: Uses CallableStatement.
	 * */
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		
		String sql = "{call \"getProducts\"()}";
		
		try( CallableStatement ctmnt = conn.prepareCall(sql);
				ResultSet rs = ctmnt.executeQuery();){
			
			while( rs.next() ){
				products.add(new Product(rs.getInt("id"),rs.getString("name")));
			}
			
		} catch (SQLException e) {
			System.out.println("Something wrong happened while executing getAllProducts()!");
			e.printStackTrace();
		}
		return products;
	}
	
	@Override
	public Product getProduct(Product product) {
		return getProduct(product.getId(), product.getName());
	}

	/**
	 * Note: Uses PreparedStatement.
	 * */
	@Override
	public Product getProduct(int id, String name) {
		Product product = null;
		
		String sql = "SELECT * FROM public.\"Product\" WHERE id=? AND name=?;";
		
		try( PreparedStatement pstmnt = conn.prepareStatement(sql); ){
			
			pstmnt.setInt(1, id);
			pstmnt.setString(2, name);
			
			ResultSet rs = pstmnt.executeQuery();
			while( rs.next() ){
				product = new Product(rs.getInt("id"),rs.getString("name"));
			}
			
		} catch (SQLException e) {
			System.out.println("Something wrong happened while executing getProduct()!");
			e.printStackTrace();
		}
		return product;
	}
}
