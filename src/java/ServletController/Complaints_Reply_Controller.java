/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model_class.DBconnecton;

/**
 *
 * @author farzana
 */
public class Complaints_Reply_Controller extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String sId=request.getParameter("serialId");
            String reply=request.getParameter("comment");
            String studentID=request.getParameter("stdudentID");
 
            Connection connection=null;
            Statement statement=null;
            int i=0;
                try {
            connection=DBconnecton.creatConnection();
            statement=connection.createStatement();
          
             i = statement.executeUpdate("insert into reply_complaints(sid, studentID, reply, replydate) "
                     + "values('"+sId+"','"+studentID+"','"+reply+"',CURDATE())");
         } catch (SQLException ex) {
             Logger.getLogger(student_complaint_controller.class.getName()).log(Level.SEVERE, null, ex);
         }


if(i>0)                
 response.sendRedirect("Admin_Complaints_Controller");            
else    
     response.sendRedirect("admin_home_page.jsp");
}   

         
         
    }
