/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model_class.DBconnecton;

/**
 *
 * @author farzana
 */
public class Adimin_info_Update extends HttpServlet {

   

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name=request.getParameter("adminName");
                 String password=request.getParameter("password");

        Connection con=null;
        Statement st=null;
        con=DBconnecton.creatConnection();
        int upd=0;
       
       String sql = "UPDATE admin_info SET name=?, password=? WHERE sid=1";
 
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Adimin_info_Update.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            statement.setString(1, name);
           statement.setString(2, password);
        } catch (SQLException ex) {
            Logger.getLogger(Adimin_info_Update.class.getName()).log(Level.SEVERE, null, ex);
        }
              

        try {
            upd = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Adimin_info_Update.class.getName()).log(Level.SEVERE, null, ex);
        }

                   if(upd>0){
                     response.sendRedirect("Admin_Info.jsp");
                     }
                    else {
                           response.sendRedirect("admin_home_page.jsp");

                    }
}
  


}

        
        
    


