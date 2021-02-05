package controller;

import DAO.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bookDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        BookDAO bd = new BookDAO();
        
        String del = bd.delBook(id);
        
        if(del.equals("SUCCESS"))
            request.getRequestDispatcher("/frmListBook.jsp").forward(request, response);
        
        else{
            request.setAttribute("errMessage", del);
            request.getRequestDispatcher("/frmListBook.jsp").forward(request, response);
        }
    }
}
