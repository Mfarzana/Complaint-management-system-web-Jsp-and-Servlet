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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model_class.DBconnecton;

/**
 *
 * @author farzana
 */
public class Login_Controller extends HttpServlet {

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
          String name=request.getParameter("userName");
        String Pass=request.getParameter("password");
        String loginType=request.getParameter("login");
       
         
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        
        connection=DBconnecton.creatConnection();
        HttpSession session=request.getSession(true);
        
        if(loginType.equals("Admin")){
            
                    try {
              statement=connection.createStatement();
              rs=statement.executeQuery("select * from admin_info where name='"+name+"' "
            + "and password='"+Pass+"'");

            if(rs.next()){

            session.setAttribute("name",name );
            response.sendRedirect("admin_home_page.jsp");
            }  
            else
                  //System.out.println(" invalid password <a href='index.jsp'> try again </a>");
                  response.sendRedirect("index.jsp");
              
              
              
          } catch (SQLException ex) {
              System.out.println("ServletController.Login_Controller.doPost() error");
          }
          
        }
         
         
         
        else if(loginType.equals("Student")) {
     
             try {
              statement=connection.createStatement();
              rs=statement.executeQuery("select * from student_registration_info where userName='"+name+"' "
            + "and password='"+Pass+"'");

        if(rs.next()){

        session.setAttribute("userid", name);
        response.sendRedirect("student_success_log.jsp");
        }  
        else
             // System.out.println(" invalid password <a href='index.jsp'> try again </a>");
              response.sendRedirect("index.jsp");

              
              
          } catch (SQLException ex) {
              Logger.getLogger(Login_Controller.class.getName()).log(Level.SEVERE, null, ex);
          }
          
   
     
     }  
        
        
        
      
        
    }

 
}
