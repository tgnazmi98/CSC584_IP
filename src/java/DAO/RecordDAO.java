package DAO;

import bean.RecordBean;
import java.sql.*;
import util.DBConn1;

public class RecordDAO {
    
    Connection con = null;
    PreparedStatement ps = null;
    
    public String addRecord(RecordBean rb){
        try{
            con = DBConn1.createConnection();
            ps = con.prepareStatement("INSERT INTO RECORD (STUDENTID, BOOKID, STARTDATE, RETURNDATE) VALUES (?,?,?,?)");
            ps.setInt(1, rb.getSid());
            ps.setInt(2, rb.getBid());
            ps.setString(3, rb.getSdate());
            ps.setString(4, rb.getEdate());
            ps.execute();
            return "SUCCESS";
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return "FAILED TO ADD RECORD";
    }
    
    public String updateRecord(RecordBean rb){
        try{
            con = DBConn1.createConnection();
            ps = con.prepareStatement("UPDATE RECORD SET STUDENTID=" + rb.getSid() + ", BOOKID=" + rb.getBid() +", STARTDATE='" + rb.getSdate() + "', RETURNDATE='" + rb.getEdate() +"' WHERE RECORDID=" + rb.getId());
            ps.executeUpdate();
            return "SUCCESS";
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return "FAILED TO UPDATE RECORD";
    }
    public String delRecord(int i){
        try{
            con = DBConn1.createConnection();
            ps = con.prepareStatement("DELETE FROM RECORD WHERE RECORDID=" + i);
            ps.executeUpdate();
            return "SUCCESS";
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return "FAILED TO DELETE RECORD";
    }
    
    
}
