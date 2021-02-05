package controller;

import DAO.BookDAO;
import bean.BookBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        int id = Integer.parseInt(request.getParameter("sid"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        
        
        BookBean bb = new BookBean(id, title, author);
        
        BookDAO bd = new BookDAO();
         
        String update = bd.updateBook(bb);
        
        if (update.equals("SUCCESS")){
            request.getRequestDispatcher("/frmListBook.jsp").forward(request, response);
        }
        
        else{
            request.setAttribute("errMessage", update);
            request.getRequestDispatcher("/frmListBook.jsp").forward(request, response);
        }   
    }
}
