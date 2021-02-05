package controller;

import DAO.UserDAO;
import bean.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        int id = Integer.parseInt(request.getParameter("sid"));
        String password = request.getParameter("pass");
        String name = request.getParameter("name");
        
        UserBean rb = new UserBean(id, password, name);
        
        UserDAO rd = new UserDAO();
        
        String update = rd.updateUser(rb);
        
        if(update.equals("SUCCESS"))
            request.getRequestDispatcher("/frmListUser.jsp").forward(request, response);
        
        else{
            request.setAttribute("errMessage", update);
            request.getRequestDispatcher("/frmListUser.jsp").forward(request, response);
        }
        
        
    }
}
