package hu.schonherz.java.training.hw4.mainservice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import hu.schonherz.java.training.hw4.connection.ConnectionHandler;
import hu.schonherz.java.training.hw4.dao.OrderDao;
import hu.schonherz.java.training.hw4.dao.ProductDao;
import hu.schonherz.java.training.hw4.dao.UserDao;
import hu.schonherz.java.training.hw4.dao.impl.OrderDaoImpl;
import hu.schonherz.java.training.hw4.dao.impl.ProductDaoImpl;
import hu.schonherz.java.training.hw4.dao.impl.UserDaoImpl;
import hu.schonherz.java.training.hw4.dto.Order;
import hu.schonherz.java.training.hw4.dto.Product;
import hu.schonherz.java.training.hw4.dto.User;

public class Main {
	
	/**
	 * Method to print out some meta information about the database.
	 * */
	private static void gatherMetaData(){
		DatabaseMetaData dbmeta;
		// Get some metadata like table names and their columns
		try( Connection conn = ConnectionHandler.getConnection(); ){
			dbmeta = conn.getMetaData();
			
			// get all tables
			System.out.println("The tables of the database:");
			ResultSet tables = dbmeta.getTables(null, null, "%", new String[]{"TABLE"});
			
			// for every table
			while( tables.next() ){
				System.out.println("Table name: " + tables.getString(3));
				System.out.println("The columns of this table:");
				
				try( Statement stmnt = conn.createStatement() ){
					// get all of its columns
					String sql = "SELECT * FROM public.\"" + tables.getString(3) + "\";";
					ResultSet columns = stmnt.executeQuery(sql);
					
					// get the metadata of the columns
					ResultSetMetaData rsmd = columns.getMetaData();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						System.out.println("Column name: " + rsmd.getColumnName(i));
					}
				}
			}
			
			System.out.println("\n");
			
		} catch (SQLException sqle) {
			System.out.println("Something sqlistic happened during the metadata gathering!");
			sqle.printStackTrace();
		}		
	}

	public static void main(String[] args) {
		
		gatherMetaData();
		
		UserDao ud = new UserDaoImpl();
		ProductDao pd = new ProductDaoImpl();
		OrderDao od = new OrderDaoImpl();
		
		// a) Egy adott felhasználó rendeléseinek lekérdezése (PreparedStatement)
		User adamb = new User(1, "Bertalan Adam");	
		List<Product> adambOrders = ud.getOrdersOfUser( adamb );
		
		System.out.println("Orders of Bertalan Adam:");
		for (Product product : adambOrders) {
			System.out.println("PRODUCT ID: " + product.getId() + " PRODUCT NAME: " + product.getName());
		}
		
		// b) Felhasználók lekérdezése (CallableStatement)
		List<User> users = ud.getAllUsers();
		
		System.out.println("List of all users:");
		for (User user : users) {
			System.out.println("USER ID: " + user.getId() + " USER NAME: " + user.getName());
		}
		
		// c) Termékek lekérdezése (CallableStatement)
		List<Product> products = pd.getAllProducts();
		
		System.out.println("List of all products:");
		for (Product product : products) {
			System.out.println("PRODUCT ID: " + product.getId() + " PRODUCT NAME: " + product.getName());
		}

		// d) Rendelések lekérdezése (Statement)
		List<Order> orders = od.getAllOrders();
		
		System.out.println("List of all orders:");
		for (Order order : orders) {
			System.out.println("ORDER USER_ID: " + order.getUser_id() + " ORDER PRODUCT_ID " + order.getProduct_id() );
		}
		
		// 3) Termékek kötegelt beszúrása tetszőleges számban (azért több mint 5) és tetszőleges kötegméretben (azért nagyobb mint 1)
		final int batchSizeInsert = 3;
		int count = 0;
		String[] inserts = {"INSERT INTO public.\"Product\" (name) VALUES ('Fogkefe');",
							"INSERT INTO public.\"Product\" (name) VALUES ('Majkrem');",
							"INSERT INTO public.\"Product\" (name) VALUES ('Paprika');",
							"INSERT INTO public.\"Product\" (name) VALUES ('Villanykorte');",
							"INSERT INTO public.\"Product\" (name) VALUES ('Fluxuskondenzator');",
							"INSERT INTO public.\"Product\" (name) VALUES ('Segway');",
							"INSERT INTO public.\"Product\" (name) VALUES ('Laptop');"
		};
		
		try( Connection conn = ConnectionHandler.getConnection();
				Statement stmnt = conn.createStatement()){
			conn.setAutoCommit(false);
			
			for (String insert : inserts) {
				stmnt.addBatch(insert);
				
				if( ++count % batchSizeInsert == 0 ){
					stmnt.executeBatch();
				}
			}
			stmnt.executeBatch();
			conn.commit();
		}
		catch (SQLException e) {
			System.out.println("Something bad happened during the FIRST BATCH INSERT!");
			e.printStackTrace();
		}
		
		// 4) Termékek kötegelt törlése tetszőleges számban és tetszőleges kötegméretben (azért nagyobb mint 1)
		final int batchSizeDelete = 2;
		count = 0;
		String[] deletes = {"DELETE FROM public.\"Product\" WHERE name='Fogkefe';",
							"DELETE FROM public.\"Product\" WHERE name='Majkrem';",
							"DELETE FROM public.\"Product\" WHERE name='Paprika';"
		};
		
		try( Connection conn = ConnectionHandler.getConnection();
				Statement stmnt = conn.createStatement(); ){
			conn.setAutoCommit(false);
			
			for (String delete : deletes) {
				stmnt.addBatch(delete);
				count++;
				if( count % batchSizeDelete == 0 ){
					stmnt.executeBatch();
				}
			}
			stmnt.executeBatch();
			conn.commit();
		}
		catch (SQLException sqle) {
			System.out.println("Something bad happened during the SECOND BATCH INSERT!");
			sqle.printStackTrace();
		}
	}
}
