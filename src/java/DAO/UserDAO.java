package DAO;

import bean.UserBean;
import util.DBConn1;
import java.sql.*;

public class UserDAO {
    
    Connection con = DBConn1.createConnection();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
        
    public String addUser(UserBean ub){
        
        try{
            
            con = DBConn1.createConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT STAFFID FROM LOGIN WHERE STAFFID=" + ub.getId());
            
            if(rs.next())
                return "ID HAS ALREADY REGISTERED";
            
            ps = con.prepareStatement("INSERT INTO LOGIN (STAFFID, PASSWORD, FIRSTNAME) VALUES (" + ub.getId() +", '" + ub.getPassword() + "', '" + ub.getName() +"')");
            ps.execute();
            return "SUCCESS";
            
        }
        catch(SQLException e){
        }
        
        return "FAILED TO ADD USER";
    }
    
    public String deleteUser(int id){
        
        try{
            ps = con.prepareStatement("DELETE FROM LOGIN WHERE STAFFID=" + id);
            ps.execute();
            return"SUCCESS";
        }
        
        catch(SQLException e){
        }
        
        return "FAILED TO DELETE USER";
    
    }
    
    public String updateUser(UserBean ub){
        
        try{
            ps = con.prepareStatement("UPDATE LOGIN SET PASSWORD='" + ub.getPassword() + "', FIRSTNAME='" + ub.getName() + "' WHERE STAFFID=" + ub.getId());
            ps.execute();
            return "SUCCESS";
        }
        
        catch(SQLException e){
        }
        
        return "FAILED TO UPDATE USER";
    }
    
    public String verifyUser(UserBean ub){
        
        int idDB;
        String passwordDB;
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT STAFFID, PASSWORD FROM LOGIN");
            while (rs.next()){
                idDB = rs.getInt("STAFFID");
                passwordDB = rs.getString("PASSWORD");
                if (idDB==ub.getId() && passwordDB.equals(ub.getPassword()))
                    return "SUCCESS";
            }
        }
        catch (SQLException e){}
        
        return "Invalid User Credential";
    }
    
}
