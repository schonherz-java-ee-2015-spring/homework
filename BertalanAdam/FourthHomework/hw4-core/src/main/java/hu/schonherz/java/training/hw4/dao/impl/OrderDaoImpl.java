package hu.schonherz.java.training.hw4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.hw4.connection.ConnectionHandler;
import hu.schonherz.java.training.hw4.dao.OrderDao;
import hu.schonherz.java.training.hw4.dto.Order;

public class OrderDaoImpl implements OrderDao {
	
	private Connection conn = null;
	
	/**
	 * Parameterless constructor to build the connection.
	 * */
	public OrderDaoImpl() {
		try {
			conn = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			System.out.println("Something happened in the OrderDaoImpl constructor! Maybe due to unsuccessful connecting.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes a query with two parameters.
	 * Note: Uses PreparedStatement.
	 * @param user_id The first parameter of the query.
	 * @param product_id The second parameter of the query.
	 * @param sql The sql expression that will be executed.
	 * @return A boolean indicating the success of the operation.
	 * */
	private boolean executeOwnQuery(int user_id, int product_id, String sql){
		
		boolean executeresult = false;
		try( PreparedStatement pstmnt = conn.prepareStatement(sql); ){
						
			pstmnt.setInt(1, user_id);
			pstmnt.setInt(2, product_id);
			
			executeresult = pstmnt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return executeresult;
	}
	
	@Override
	public boolean addOrder( Order order ){
		return addOrder( order.getUser_id(), order.getProduct_id());
	}

	@Override
	public boolean addOrder(int user_id, int product_id) {
		return executeOwnQuery(user_id, product_id, "INSERT INTO public.\"Order\" (user_id, product_id) VALUES (?,?);");
	}

	@Override
	public boolean deleteOrder( Order order ){
		return deleteOrder(order.getUser_id(), order.getProduct_id());
	}
	
	@Override
	public boolean deleteOrder( int user_id, int product_id ) {
		return executeOwnQuery(user_id, product_id, "DELETE FROM public.\"Order\" WHERE user_id=? AND product_id=?;");
	}

	/**
	 * Note: Uses Statement.
	 * */
	@Override
	public List<Order> getAllOrders() {
		
		List<Order> orders = new ArrayList<>();
		String sql = "SELECT * FROM public.\"Order\";";

		try( Statement stmnt = conn.createStatement(); 
				ResultSet rs = stmnt.executeQuery(sql); ){

			while( rs.next() ){
				orders.add(new Order(rs.getInt("user_id"),rs.getInt("product_id")));
			}
			
		} catch (SQLException e) {
			System.out.println("Something wrong happened while executing getAllOrders()!");
			e.printStackTrace();
		}
		return orders;
	}
	
	@Override
	public Order getOrder( Order order ) {
		return getOrder( order.getUser_id(), order.getProduct_id());
	}

	/**
	 * Note: Uses PreparedStatement.
	 * */
	@Override
	public Order getOrder(int user_id, int product_id) {
		String sql = "SELECT * FROM public.\"Order\" WHERE user_id=? AND product_id=?;";
		Order order = null;
		
		try( PreparedStatement pstmnt = conn.prepareStatement(sql); 
				ResultSet rs = pstmnt.executeQuery(); ){

			while( rs.next() ){
				order = new Order(rs.getInt("user_id"),rs.getInt("product_id"));
			}
			
		} catch (SQLException e) {
			System.out.println("Something wrong happened while executing getOrder()!");
			e.printStackTrace();
		}
		return order;
	}
}
