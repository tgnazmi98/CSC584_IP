package controller;

import DAO.BookDAO;
import bean.BookBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        
        BookBean bb = new BookBean(title, author);
        
        BookDAO bd = new BookDAO();
        
        String add = bd.addBook(bb);
        
        if (add.equals("SUCCESS"))
            request.getRequestDispatcher("/frmListBook.jsp").forward(request, response);
        
        else{
            request.setAttribute("errMessage", add);
            request.getRequestDispatcher("/frmListBook.html").forward(request, response);
        }
           
    }


}
