package controller;

import DAO.StudentDAO;
import bean.StudentBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        
        StudentBean sb = new StudentBean(id, name);
        
        StudentDAO sd = new StudentDAO();
        
        String add = sd.addRecord(sb);
        
        if (add.equals("SUCCESS")){
            request.getRequestDispatcher("/frmListStudent.jsp").forward(request, response);
        }
        
        else{
            request.setAttribute("errMessage", add);
            request.getRequestDispatcher("/frmListStudent.html").forward(request, response);
        }
    }
}
