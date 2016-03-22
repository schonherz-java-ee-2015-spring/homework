package hu.schonherz.homework.order.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionHandler {
	
	Connection getConnection() throws SQLException;
}
