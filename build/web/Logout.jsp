<%-- 
    Document   : Student_Logout
    Created on : Jul 27, 2017, 2:53:51 PM
    Author     : farzana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
   session = request.getSession(false);
if(session != null) {
  session.invalidate();
}

Cookie killMyCookie = new Cookie("mycookie", null);
     killMyCookie.setMaxAge(0);
     killMyCookie.setPath("/");
     response.addCookie(killMyCookie);
        
  response.sendRedirect("index.jsp");
  
%>
