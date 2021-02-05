package controller;

import DAO.StudentDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class stuDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        StudentDAO sd = new StudentDAO();
        
        String del = sd.deleteRecord(id);
        
        if (del.equals("SUCCESS")){
            request.getRequestDispatcher("/frmListStudent.jsp").forward(request, response);
        }
        
        else{
            request.setAttribute("errMessage", del);
            request.getRequestDispatcher("/frmListStudent.jsp").forward(request, response);
        }
    }
}
