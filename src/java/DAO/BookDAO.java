package DAO;

import bean.BookBean;
import java.sql.*;
import util.DBConn1;

public class BookDAO {
    
    Connection con = null;
    PreparedStatement ps = null;
    
    public String updateBook(BookBean bb){
        
        try{
            con = DBConn1.createConnection();
            ps = con.prepareStatement("UPDATE BOOK SET BOOKTITLE='" + bb.getTitle() + "', BOOKAUTHOR='" + bb.getAuthor() + "' WHERE BOOKID=" + bb.getId());
            ps.executeUpdate();
            return "SUCCESS";
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return "FAILED TO UPDATE BOOK";
    }
    
    public String delBook(int id){
        try{
            con = DBConn1.createConnection();
            ps = con.prepareStatement("DELETE FROM BOOK WHERE BOOKID=" + id);
            ps.execute();
            return "SUCCESS";
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return "FAILED TO DELETE BOOK";
    }
    
    public String addBook(BookBean bb){
        try{
            con= DBConn1.createConnection();
            ps = con.prepareStatement("INSERT INTO BOOK (BOOKTITLE, BOOKAUTHOR) VALUES (?,?)");
            ps.setString(1, bb.getTitle());
            ps.setString(2, bb.getAuthor());
            ps.execute();
            return "SUCCESS";
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return "FAILED TO ADD BOOK";
    }
}
