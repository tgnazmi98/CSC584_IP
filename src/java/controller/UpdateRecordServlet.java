package controller;

import DAO.RecordDAO;
import bean.RecordBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateRecordServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int rid = Integer.parseInt(request.getParameter("rid"));
        int bid = Integer.parseInt(request.getParameter("bid"));
        int sid = Integer.parseInt(request.getParameter("sid"));
        String start = request.getParameter("sdate");
        String end = request.getParameter("edate");
        
        RecordBean rb = new RecordBean(rid, bid, sid, start, end);
        
        RecordDAO rd = new RecordDAO();
        
        String update = rd.updateRecord(rb);
        
        if(update.equals("SUCCESS"))
            request.getRequestDispatcher("/frmListRecord.jsp").forward(request, response);
        
        else{
            request.setAttribute("errMessage", update);
            request.getRequestDispatcher("/frmListRecord.jsp").forward(request, response);
        }
    }
}
