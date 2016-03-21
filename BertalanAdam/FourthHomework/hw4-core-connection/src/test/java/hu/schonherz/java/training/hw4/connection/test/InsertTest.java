package hu.schonherz.java.training.hw4.connection.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hu.schonherz.java.training.hw4.connection.ConnectionHandler;

public class InsertTest {
	
	Connection conn;

	@Before
	public void setUp() throws Exception {
		conn = ConnectionHandler.getConnection();
		conn.setAutoCommit(false);
	}

	@After
	public void tearDown() throws Exception {
		conn.rollback();
		conn.close();
	}
	
	@Test
	public void insertOrderWithTwoParameters(){
		String sql = "INSERT INTO public.\"Order4\" (user_id, product_id) VALUES (1,1)";
		try {
			PreparedStatement pstmnt = conn.prepareStatement(sql);
			pstmnt.executeQuery();
		} catch (SQLException e) {
			assert false : "Shoud not throw exception.";
		}
	}
	
	@Test(expected=SQLException.class)
	public void insertOrderWithTwoParametersExc() throws SQLException{
		String sql = "INSERT INTO public.\"Order4\" (user_id, product_id) VALUES (0,-1)";
			PreparedStatement pstmnt = conn.prepareStatement(sql);
			pstmnt.executeQuery();
	}

}
