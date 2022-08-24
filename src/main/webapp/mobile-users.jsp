<%@page import=" java.util.ArrayList" %>
<%@page import=" com.codewithkrish.newmobile.model.User" %>
<%@page import=" java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TechMart</title>
</head>
<body>
  <h1>Welcome to TechMart</h1>
  <br>
  <br>
  <p>
    <%
        out.println(request.getAttribute("message"));
    %>
  </p>
  <br>
  <table>
      <thead>
         <tr>
            <th>User Id</th>
            <th>User Name</th>
            <th>Address</th>
            <th>Account No</th>
            <th>Branch No</th>
            <th>User Password</th>
            <th>Role Id</th>
         </tr>
      </thead>
      
      <tbody>
         <%
            List<User> users = (ArrayList<User>) request.getAttribute("userList");
            for(User u : users){
            	out.println("<tr>");
            	out.println("<td>"+u.getUserID()+"</td>");
            	out.println("<td>"+u.getUserName()+"</td>");
            	out.println("<td>"+u.getAddress()+"</td>");
            	out.println("<td>"+u.getContactNo()+"</td>");
            	out.println("<td>"+u.getBranchNo()+"</td>");
            	out.println("<td>"+u.getUserPassword()+"</td>");
            	out.println("<td>"+u.getRoleID()+"</td>");
            	out.println("</tr>");
            }
         %>
      </tbody>
  </table>
</body>
</html>