package controller;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        UserDAO rd = new UserDAO();
        
        String del = rd.deleteUser(id);
        
        if(del.equals("SUCCESS")){
            request.getRequestDispatcher("/frmListUser.jsp").forward(request, response);
        }
        
        else{
            request.setAttribute("errMessage", del);
            request.getRequestDispatcher("/frmListUser.jsp").forward(request, response);
        }
    }
}
