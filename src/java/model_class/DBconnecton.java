/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_class;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farzana
 */
public class DBconnecton {
    public static Connection creatConnection(){
     Connection connection=null;
     String url="jdbc:mysql://localhost:3306/complaint_management_system";
     String root="root";
     String password="allah";
      try {
         try {
             Class.forName("com.mysql.jdbc.Driver");
             
             
         } catch (ClassNotFoundException ex) {
             System.out.println("driver class not found");
             Logger.getLogger(DBconnecton.class.getName()).log(Level.SEVERE, null, ex);
         }
      
          connection=DriverManager.getConnection(url,root,password);
          
        } catch (SQLException ex) {
             System.out.println("connection class not found");
            Logger.getLogger(DBconnecton.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     return connection;
    }
    
}


