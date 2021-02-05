package controller;

import bean.UserBean;
import DAO.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        int username = Integer.parseInt(request.getParameter("username"));
        String password = request.getParameter("password");
        
        UserBean lb = new UserBean(username, password);
        
        UserDAO ld = new UserDAO();
        
        String verification = ld.verifyUser(lb);
        
        if (verification.equals("SUCCESS"))
            request.getRequestDispatcher("/MainMenu.html").forward(request, response);
        
        else{
            request.setAttribute("errMessage", verification);
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }
}
