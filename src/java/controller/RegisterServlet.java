package controller;

import DAO.UserDAO;
import bean.UserBean;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("sid");
        String password = request.getParameter("pword");
        String name = request.getParameter("fname");
        
        int idd = Integer.parseInt(id);

        UserBean rb = new UserBean(idd, password, name);
        UserDAO rd = new UserDAO();
        
        String reg = rd.addUser(rb);
        
        if (reg.equals("SUCCESS"))
            request.getRequestDispatcher("/frmListUser.jsp").forward(request, response);
                
        else{
            request.setAttribute("errMessage", reg);
            request.getRequestDispatcher("/frmListUser.html").forward(request, response);
        }  
    }
}