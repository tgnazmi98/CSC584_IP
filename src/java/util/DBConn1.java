package util;

import java.sql.*;

public class DBConn1 {
    
    public static Connection createConnection(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/LMS", "app", "app");
            return conn;
        }
        catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
