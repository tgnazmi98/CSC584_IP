package controller;

import DAO.StudentDAO;
import bean.StudentBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("sid");
        System.out.println(id);
        String name = request.getParameter("name");
        int id1 = Integer.parseInt(id);
        StudentBean sb = new StudentBean(id1, name);
        
        StudentDAO sd = new StudentDAO();
        
        String update = sd.updateStudent(sb);
        
        if (update.equals("SUCCESS")){
            request.getRequestDispatcher("/frmListStudent.jsp").forward(request, response);
        }
        
        else{
            request.setAttribute("errMessage", update);
            request.getRequestDispatcher("/frmListStudent.jsp").forward(request, response);
        }
    }
}
