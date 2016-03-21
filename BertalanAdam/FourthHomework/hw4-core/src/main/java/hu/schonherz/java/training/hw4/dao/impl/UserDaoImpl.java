package hu.schonherz.java.training.hw4.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.hw4.connection.ConnectionHandler;
import hu.schonherz.java.training.hw4.dao.UserDao;
import hu.schonherz.java.training.hw4.dto.Product;
import hu.schonherz.java.training.hw4.dto.User;

public class UserDaoImpl implements UserDao {
	
	private Connection conn;

	/**
	 * Parameterless constructor to build the connection.
	 * */
	public UserDaoImpl() {
		try {
			conn = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			System.out.println("Something wrong happened at the UserDaoImpl constructor!");
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
	public boolean addUser(User user) {
		return addUser(user.getId(), user.getName());
	}

	@Override
	public boolean addUser(int id, String name) {
		return executeOwnQuery(id, name, "INSERT INTO public.\"User\" (id, name) VALUES (?,?);");
	}

	/**
	 * Note: Uses PreparedStatement.
	 * */
	@Override
	public boolean updateUser(User user) {
		String sql = "UPDATE public.\"User\" SET name=? WHERE id=?;";
		boolean executeresult = false;
		
		try( PreparedStatement pstmnt = conn.prepareStatement(sql); ){
			
			pstmnt.setString(1, user.getName());
			pstmnt.setInt(2, user.getId());
			
			executeresult = pstmnt.execute();
			
		} catch (SQLException e) {
			System.out.println("Something wrong happened while executing updateUser()!");
			e.printStackTrace();
		}
		
		return executeresult;
	}
	
	@Override
	public boolean deleteUser(User user) {
		return deleteUser( user.getId(), user.getName());
	}
	
	@Override
	public boolean deleteUser(String name){
		return deleteUser( 0, name );
	}
	
	@Override
	public boolean deleteUser(int id, String name) {
		return executeOwnQuery(id, name, "DELETE FROM public.\"User\" WHERE id=? OR name=?;");
	}

	/**
	 * Note: Uses CallableStatement.
	 * */
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String sql = "{call \"getUsers\"()}";
		
		try( CallableStatement ctmnt = conn.prepareCall(sql);
				ResultSet rs = ctmnt.executeQuery()){
			
			while( rs.next() ){
				users.add(new User(rs.getInt("id"),rs.getString("name")));
			}
			
		} catch (SQLException e) {
			System.out.println("Something wrong happened while executing getAllUsers()!");
			e.printStackTrace();
		}
		
		return users;
	}
	
	@Override
	public User getUser(User user) {
		return getUser( user.getId(), user.getName());
	}

	/**
	 * Note: Uses PreparedStatement.
	 * */
	@Override
	public User getUser(int id, String name) {
		User user = null;
		String sql = "SELECT * FROM public.\"User\" WHERE id=? AND name=?;";
		
		try( PreparedStatement pstmnt = conn.prepareStatement(sql); ){
			
			pstmnt.setInt(1, id);
			pstmnt.setString(2, name);
			
			ResultSet rs = pstmnt.executeQuery();
					
			while( rs.next() ){
				user = new User(rs.getInt("id"),rs.getString("name"));
			}
			
		} catch (SQLException e) {
			System.out.println("Something wrong happened while executing getUser()!");
			e.printStackTrace();
		}
		
		return user;
	}
	
	@Override
	public List<Product> getOrdersOfUser(User user) {
		return getOrdersOfUser(user.getId(), user.getName());
	}

	/**
	 * Note: Uses PreparedStatement.
	 * */
	@Override
	public List<Product> getOrdersOfUser(int id, String name) {
		List<Product> products = new ArrayList<>();
		
		String sql = "SELECT P.id, P.name FROM "
				+ "public.\"Product\" AS P INNER JOIN public.\"Order\" AS O ON "
				+ "P.id = O.product_id INNER JOIN public.\"User\" AS U ON "
				+ "O.user_id = U.id WHERE U.id=? AND U.name=?;";
		
		try( PreparedStatement pstmnt = conn.prepareStatement(sql); ){
			pstmnt.setInt(1, id);
			pstmnt.setString(2, name);
			
			ResultSet rs = pstmnt.executeQuery();
			
			while( rs.next() ){
				products.add( new Product(rs.getInt("id"), rs.getString("name")));
			}
			
		} catch (SQLException e) {
			System.out.println("Something wrong happened while executing getOrderOfUser()!");
			e.printStackTrace();
		}
		return products;
	}
}
