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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
public class Admin_teachers_Complaints_Controller extends HttpServlet {

 private ServletConfig config;
   String page="View_Complaints.jsp";

 public void init(ServletConfig config)
  throws ServletException{
    this.config=config;
 }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException,IOException
{
  Connection connection= null;
  Statement statement=null;
  ResultSet rs;
  List dataList=new ArrayList(); 
  try {
      
  String sql = "select * from student_complaints where complaintsType = 'teachers '" ;
  connection=DBconnecton.creatConnection();
  statement=connection.createStatement();
  statement.executeQuery (sql);
  rs = statement.getResultSet();
  
  while (rs.next ()){
      
  dataList.add(rs.getString("sid"));
  dataList.add(rs.getString("studentId"));
  dataList.add(rs.getString("studentName"));
  dataList.add(rs.getString("department"));
  dataList.add(rs.getString("complaintsType"));
  dataList.add(rs.getString("comment"));
  dataList.add(rs.getString("date"));
  
  
  
  }

  rs.close ();
  statement.close ();

  }catch(Exception e){
  System.out.println("Exception is ;"+e);

  }

  request.setAttribute("data",dataList);
  RequestDispatcher dispatcher = request.getRequestDispatcher(page);
   if (dispatcher != null){
  dispatcher.forward(request, response);

   } 

  }

} 