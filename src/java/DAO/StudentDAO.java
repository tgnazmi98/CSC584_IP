package DAO;

import bean.StudentBean;
import java.sql.*;
import util.DBConn1;

public class StudentDAO {
    
    Connection con = null;
    PreparedStatement ps = null;
        
    public String updateStudent(StudentBean sb){
      int id = sb.getId();
      String name = sb.getName();

      try{
          con = DBConn1.createConnection();
          ps = con.prepareStatement("UPDATE STUDENT SET STUDENTNAME='" + name + "' WHERE STUDENTID=" + id);
          ps.executeUpdate();
          return "SUCCESS";
      }
      catch(SQLException e){
          e.printStackTrace();
      }
      
      return "FAILED TO UPDATE STUDENT";  
    }
    
    public String deleteRecord(int i){
        
        try{
            con = DBConn1.createConnection();
            ps = con.prepareStatement("DELETE FROM STUDENT WHERE STUDENTID=" + i);
            ps.execute();
            return "SUCCESS";
        }
        
        catch(SQLException e){
          e.printStackTrace();
        }
        
        return "FAILED TO DELETE STUDENT";
    }
    
    public String addRecord(StudentBean sb){
        
        try{
            con = DBConn1.createConnection();
            ps = con.prepareStatement("INSERT INTO STUDENT (STUDENTID, STUDENTNAME) VALUES (?, ?)");
            ps.setInt(1, sb.getId());
            ps.setString(2, sb.getName());
            ps.executeUpdate();
            return "SUCCESS";
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return "FAILED TO ADD STUDENT";
    }   
}
