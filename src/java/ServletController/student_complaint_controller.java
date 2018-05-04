/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model_class.DBconnecton;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farzana
 */
public class student_complaint_controller extends HttpServlet {

   

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
            String studentId=request.getParameter("studentID");
            String studentName=request.getParameter("studentName");
            String department=request.getParameter("department");
            String complaintType=request.getParameter("complaint");
            String comment=request.getParameter("comment");
            
            Connection connection=null;
            Statement statement=null;
            int i=0;
                try {
            connection=DBconnecton.creatConnection();
            statement=connection.createStatement();
          
             i = statement.executeUpdate("insert into student_complaints(studentId, studentName, department, complaintsType,comment,date) "
                     + "values('"+studentId+"','"+studentName+"','"+department+"','"+complaintType+"','"+comment+"',CURDATE())");
         } catch (SQLException ex) {
             Logger.getLogger(student_complaint_controller.class.getName()).log(Level.SEVERE, null, ex);
         }


if(i>0)                
 response.sendRedirect("student_success_log.jsp");            
else    
     response.sendRedirect("student_success_log.jsp");
}   

         
         
    }

    


