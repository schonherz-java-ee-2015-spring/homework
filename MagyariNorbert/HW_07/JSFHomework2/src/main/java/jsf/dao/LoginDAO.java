package jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import jsf.util.DataConnect;
 
public class LoginDAO {
 
    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
 
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select userName, password from public.User where userName = ? and password = ?");
            ps.setString(1, user);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
    }
}