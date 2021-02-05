package controller;

import DAO.RecordDAO;
import bean.RecordBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addRecordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int bid = Integer.parseInt(request.getParameter("bid"));
        int sid = Integer.parseInt(request.getParameter("sid"));
        String sdate = request.getParameter("sdate");
        String edate = request.getParameter("edate");
        
        RecordBean rb = new RecordBean(bid, sid, sdate, edate);
        
        RecordDAO rd = new RecordDAO();
        
        String add = rd.addRecord(rb);
        
        if (add.equals("SUCCESS"))
            request.getRequestDispatcher("/frmListRecord.jsp").forward(request, response);
        
        else{
            request.setAttribute("errMessage", add);
            request.getRequestDispatcher("/frmListRecord.html").forward(request, response);
        }        
    }
}
